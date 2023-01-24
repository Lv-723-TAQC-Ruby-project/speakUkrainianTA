package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.ChallengeClient;
import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.models.*;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallengeTest {
    protected static final ConfigProperties configProperties = new ConfigProperties();
    @Description("success SingIn")
    @Test
    public void badPost1() {
        ChallengeClient client = new ChallengeClient();
        ChallengPostRequest requestBody = new ChallengPostRequest("name",
                "title",
                "description",
                "https://docs.google.com/forms/d/e/145/viewform?embedded=true",
                "/upload/1/1.png",
                0);
        ErrorResponse response = client.badPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 401);
        softAssert.assertEquals(response.getMessage(), "You have no necessary permissions (role)");
        softAssert.assertAll();
    }

    @Description("success SingIn")
    @Test
    public void sPost1() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
        SingInResponse responseSI = clientSI.post(credential);
        ChallengeClient client = new ChallengeClient(responseSI.getAccessToken());
        int sortNumber = 111; // ToDo get DB
        ChallengPostRequest requestBody = new ChallengPostRequest("name1",
                "title",
                "stringstringstringstringstringstringstri",
                "https://docs.google.com/forms/d/e/145/viewform?embedded=true",
                "/upload/1/1.png",
                sortNumber);
        ChallengePostResponse response = client.successPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getDescription(), requestBody.getDescription());
        softAssert.assertEquals(response.getSortNumber(), sortNumber);
        softAssert.assertEquals(response.getUser().getFirstName(), "Admin");
        softAssert.assertAll();
    }
}
