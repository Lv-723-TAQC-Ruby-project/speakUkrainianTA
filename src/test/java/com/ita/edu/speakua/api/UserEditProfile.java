package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.clients.UserClient;
import com.ita.edu.speakua.api.models.SingInRequest;
import com.ita.edu.speakua.api.models.SingInResponse;
import com.ita.edu.speakua.api.models.UserRequest;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserEditProfile {
    protected static final ConfigProperties configProperties = new ConfigProperties();

    private UserClient client;

    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getUserSoyecEmail(), configProperties.getUserSoyecPassword());
        SingInResponse responseSI = clientSI.post(credential);
        client = new UserClient(responseSI.getAccessToken());
    }

    @Description("TUA-408 - User can edit profile with valid data")
    @Test
    public void userCanEditProfileWithValidData(){
        String firstName = "Anna";
        String lastName = "Kukarska";
        String phone = "0123456789";
        int id = 203;
        UserRequest requestBody = new UserRequest(id,
                "soyec48727@busantei.com",
                "Nastia",
                "Kukh",
                 "0123456786",
                "ROLE_MANAGER",
                null,
                true);
        Response response = client.put(requestBody,id);
        Assert.assertEquals(response.statusCode(), 200);

        requestBody.setFirstName(firstName);
        response = client.put(requestBody,id);
        Assert.assertEquals(response.statusCode(), 200);

        requestBody.setLastName(lastName);
        response = client.put(requestBody,id);
        Assert.assertEquals(response.statusCode(), 200);

        requestBody.setPhone(phone);
        response = client.put(requestBody,id);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
