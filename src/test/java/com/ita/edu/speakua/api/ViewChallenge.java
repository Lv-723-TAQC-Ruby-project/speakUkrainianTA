package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.ChallengeClient;
import com.ita.edu.speakua.api.clients.ClubClient;
import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.models.*;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewChallenge {
    protected static final ConfigProperties configProperties = new ConfigProperties();
    private ChallengeClient client;

    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getUserEmail(), configProperties.getUserPassword());
        SingInResponse responseSI = clientSI.post(credential);
        client = new ChallengeClient(responseSI.getAccessToken());
    }

    @Description("TUA-437 - Verify that user with any rights can view info about specific Challenge")
    @Test
    public void userViewChallenge() {
        Response response = client.getById(212);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
