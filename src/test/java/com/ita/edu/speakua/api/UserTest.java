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

        User user = requestBody.toBuilder().build();
        user.setFirstName("NastiaNastiaNastiaNastiaNastia");
        response = client.badPut(user);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"\"firstName\" can contain from 1 to 25 letters");

        user = requestBody.toBuilder().build();
        user.setFirstName("Nastia!@##$#$%");
        response = client.badPut(user);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"\"firstName\" can contain only ukrainian and english letters");

        user = requestBody.toBuilder().build();
        user.setLastName("Kukhar#%$#");
        response = client.badPut(user);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"\"lastName\" can contain only ukrainian and english letters");

        user = requestBody.toBuilder().build();
        user.setLastName("KukharKukharKukharKukharKukharKukharKukhar#");
        response = client.badPut(user);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"\"lastName\" can contain from 1 to 25 letters");

        user = requestBody.toBuilder().build();
        user.setLastName("Kukhar123343#");
        response = client.badPut(user);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"\"lastName\" can`t contain numbers");
        softAssert.assertAll();

    }
}
