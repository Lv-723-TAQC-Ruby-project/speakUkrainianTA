package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.ClubClient;
import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.models.*;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import java.util.List;

public class ClubTest {
    protected static final ConfigProperties configProperties = new ConfigProperties();
    private ClubClient client;

    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
        SingInResponse responseSI = clientSI.post(credential);
        client = new ClubClient(responseSI.getAccessToken());
    }


     @Description("Successful creating club")
    @Test
    public void successfulPost() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String clubName = "Голосистi діти " + timestamp;
        List<String> categoriesName = new ArrayList<String>() {
            {
                add("Вокальна студія, музика, музичні інструменти");
            }
        };
        Location location = Location
                .builder()
                .name("Голосівська")
                .cityName("Київ")
                .districtName("Голосіївський")
                .stationName("Голосіївська")
                .address("https://speak-ukrainian.org.ua/dev/club/910")
                .coordinates("50.35535081747696, 30.51765754176391")
                .phone("0937777777")
                .key(0.00)
                .build();

        List<Location> locations = new ArrayList<Location>() {
            {
                add(location);
            }
        };
        ClubPostRequest requestBody = new ClubPostRequest(
                clubName,
                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"аааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
                2,
                categoriesName,
                locations,
                2,
                18,
                null,
                null,
                true,
                "{\"1\"::\"ліл\"}",
                264
        );
        Response response = this.client.successPost(requestBody);
        ClubPostResponse clubsResponse = response.as(ClubPostResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(clubsResponse.getName(), clubName);
        softAssert.assertAll();
    }

    @Description("Verifying that admin can't create new club with Russian alphabet for name field")
    @Test
    public void errorMessageInvalidNameClub() {
        List<String> categoriesName = new ArrayList<>() {
            {
                add("Вокальна студія, музика, музичні інструменти");
            } };
        ClubPostRequest requestBody = new ClubPostRequest(0,
                "Тестовый экземпляр",
                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів.\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
                0,
                categoriesName,
                null,
                17,
                18,
                "/dev/static/images/user/avatar/user1.png",
                "/dev/static/images/user/avatar/user1.png",
                null,
                true,
                "testTestTest",
                true,
                999,
                999,
                999
        );
        ErrorResponse response = client.badPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertEquals(response.getMessage(), "name Помилка. Присутні недопустимі символи");
        softAssert.assertAll();
    }
}
