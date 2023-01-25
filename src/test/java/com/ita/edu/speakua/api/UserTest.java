package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.clients.UserClient;
import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.SingInRequest;
import com.ita.edu.speakua.api.models.SingInResponse;
import com.ita.edu.speakua.api.models.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserTest {

    @Description("User with invalid data cannot save changes")
    @Test
    public void invalidNameRequest(){
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest("soyec48727@busantei.com", "12345678");
        SingInResponse responseSI = clientSI.post(credential);
        UserClient client = new UserClient(responseSI.getAccessToken());
        User requestBody = new User(203,
                "soyec48727@busantei.com",
                "Nastia1234",
                "Kukh",
                "999999922",
                "ROLE_MANAGER",
                "",
                true);
        ErrorResponse response = client.badPut(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"\"firstName\" can`t contain numbers");
        softAssert.assertAll();
        User requestBody1 = new User(203,
                "soyec48727@busantei.com",
                "NastiaNastiaNastiaNastiaNastia",
                "Kukh",
                "999999922",
                "ROLE_MANAGER",
                "",
                true);
        ErrorResponse response1 = client.badPut(requestBody1);
        softAssert.assertEquals(response1.getStatus(),400);
        softAssert.assertEquals(response1.getMessage(),"\"firstName\" can contain from 1 to 25 letters");
        softAssert.assertAll();
        User requestBody2 = new User(203,
                "soyec48727@busantei.com",
                "Nastia!@##$#$%",
                "Kukh",
                "999999922",
                "ROLE_MANAGER",
                "",
                true);
        ErrorResponse response2 = client.badPut(requestBody2);
        softAssert.assertEquals(response2.getStatus(),400);
        softAssert.assertEquals(response2.getMessage(),"\"firstName\" can contain only ukrainian and english letters");
        softAssert.assertAll();
        User requestBody3 = new User(203,
                "soyec48727@busantei.com",
                "Nastia",
                "Kukhar#%$#",
                "999999922",
                "ROLE_MANAGER",
                "",
                true);
        ErrorResponse response3 = client.badPut(requestBody3);
        softAssert.assertEquals(response3.getStatus(),400);
        softAssert.assertEquals(response3.getMessage(),"\"lastName\" can contain only ukrainian and english letters");
        softAssert.assertAll();
        User requestBody4 = new User(203,
                "soyec48727@busantei.com",
                "Nastia",
                "KukharKukharKukharKukharKukharKukharKukhar#",
                "999999922",
                "ROLE_MANAGER",
                "",
                true);
        ErrorResponse response4 = client.badPut(requestBody4);
        softAssert.assertEquals(response4.getStatus(),400);
        softAssert.assertEquals(response4.getMessage(),"\"lastName\" can contain from 1 to 25 letters");
        softAssert.assertAll();
        User requestBody5 = new User(203,
                "soyec48727@busantei.com",
                "Nastia",
                "Kukhar123343#",
                "999999922",
                "ROLE_MANAGER",
                "",
                true);
        ErrorResponse response5 = client.badPut(requestBody5);
        softAssert.assertEquals(response5.getStatus(),400);
        softAssert.assertEquals(response5.getMessage(),"\"lastName\" can`t contain numbers");
        softAssert.assertAll();

    }
}
