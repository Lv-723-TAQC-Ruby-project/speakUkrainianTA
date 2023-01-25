package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.ChallengeClient;
import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.clients.UserClient;
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

    @Description("Edit Challenge with invalid data")
    @Test
    public void invalidChallengeEdit() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
        SingInResponse responseSI = clientSI.post(credential);
        ChallengeClient client = new ChallengeClient(responseSI.getAccessToken());
        ChallengePutRequest requestBody = new ChallengePutRequest("nam",
                "tit",
                "des",
                null,
                "abc",
                "abc",
                true);
        ErrorResponse response = client.unsuccessfulPut(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertEquals(response.getMessage(), "JSON parse error: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value\n" +
                " at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 102] (through reference chain: com.softserve.teachua.dto.challenge.UpdateChallenge[\"sortNumber\"])");

        ChallengePutRequest requestBody1 = new ChallengePutRequest("Lorem ipsum dolor sit amet, consect",
                "Lorem ipsum dolor sit amet, consect",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eu",
                null,
                "abc",
                "abc",
                true);
        ErrorResponse response1 = client.unsuccessfulPut(requestBody1);
        softAssert.assertEquals(response1.getStatus(), 400);
        softAssert.assertEquals(response1.getMessage(), "JSON parse error: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value\n" +
                " at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 3168] (through reference chain: com.softserve.teachua.dto.challenge.UpdateChallenge[\"sortNumber\"])");

        ChallengePutRequest requestBody2 = new ChallengePutRequest("эЭъЪыЫёЁ",
                "эЭъЪыЫёЁ",
                "эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ",
                null,
                "эЭъЪыЫёЁ",
                "эЭъЪыЫёЁ",
                true);
        ErrorResponse response2 = client.unsuccessfulPut(requestBody2);
        softAssert.assertEquals(response2.getStatus(), 400);
        softAssert.assertEquals(response2.getMessage(), "JSON parse error: Cannot deserialize value of type `long` from String \"эЭъЪыЫёЁ\": not a valid `long` value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `long` from String \"эЭъЪыЫёЁ\": not a valid `long` value\n" +
                " at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 218] (through reference chain: com.softserve.teachua.dto.challenge.UpdateChallenge[\"sortNumber\"])");
        softAssert.assertAll();
    }
}
