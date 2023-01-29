package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.clients.UserClient;
import com.ita.edu.speakua.api.models.*;
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

    @Description("Verifying that user can not save changes where mandatory fields are empty")
    @Test
    public void emptyFieldsEditUserProfile() {
        UserRequest requestBody = new UserRequest(0,
                "soyec48727@busantei.com",
                null,
                "Kukh",
                "0123456789",
                "ROLE_MANAGER",
                null,
                true);
        ErrorResponse response = client.badPut(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertEquals(response.getMessage(), "\"firstName\" can`t be null");

        requestBody.setFirstName("Nastia");
        requestBody.setLastName(null);
        response = client.badPut(requestBody);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertEquals(response.getMessage(), "\"lastName\" can`t be null");

        requestBody.setLastName("Kukh");
        requestBody.setPhone(null);
        response = client.badPut(requestBody);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertEquals(response.getMessage(), "phone must not be blank");
        softAssert.assertAll();
    }

    @Description("Verifying that user can change their role on ADMIN")
    @Test
    public void userCanChangesRoleOnAdmin() {
        UserRequest requestBody = new UserRequest(0,
                "soyec48727@busantei.com",
                "Nastia",
                "Kukh",
                "0999999922",
                "ROLE_MANAGER",
                null,
                true);
        UserResponse response = client.successfulPutChanges(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getRoleName(), "ROLE_MANAGER");
        requestBody.setRoleName("ROLE_ADMIN");
        response = client.successfulPutChanges(requestBody);
        softAssert.assertEquals(response.getRoleName(), "ROLE_ADMIN");
        softAssert.assertAll();
    }

    @Description("User can edit profile with valid data")
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
                "",
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
