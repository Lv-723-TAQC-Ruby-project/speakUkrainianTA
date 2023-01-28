package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.ClubClient;
import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.models.*;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
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


    @Description("Error creating club")
    @Test
    public void badPost() {
        List<String> categoriesName = new ArrayList<String>() {{
            add("Вокальна студія, музика, музичні інструменти");
        } };
        Location location = new Location(
                0,
                "Голосівська",
                "https://speak-ukrainian.org.ua/dev/club/910",
                0,
                0,
                0,
                "Київ",
                "Голосіївський",
                "Голосіївська",
                "50.35535081747696, 30.51765754176391",
                0,
                0,
                0,
                0,
                "937777777"
        );
        List<Location> locations = new ArrayList<Location>() {{
            add(location);
        } };
        ClubPostRequest requestBody = new ClubPostRequest(0,
                "Голосистi діти",
                "Деякий опис клубу Голосистi діти",
                0,
                categoriesName,
                locations,
                2,
                18,
                null,
                null,
                null,
                true,
                "{\"1\"::\"ліл\"}",
                true,
                264,
                0,
                0
                );
        ErrorResponse response = this.client.badPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertEquals(response.getMessage(), "Помилка під час парсингу опису. Неправильний JSON формат");
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

    @Description("Verifying that admin can't create new club with less than 5 characters for name field")
    @Test
    public void InvalidNameLessThan5CharactersClub() {
        List<String> categoriesName = new ArrayList<>() {
            {
                add("Вокальна студія, музика, музичні інструменти");
            } };
        ClubPostRequest requestBody = new ClubPostRequest(0,
                "Жук",
                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів.\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
                0,
                categoriesName,
                null,
                2,
                18,
                "/dev/static/images/user/avatar/user1.png",
                "/dev/static/images/user/avatar/user1.png",
                null,
                true,
                "{\"1\"::\"ліл\"}",
                true,
                264,
                0,
                0
        );
        ErrorResponse response = client.badPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertEquals(response.getMessage(), "name Довжина назви має бути від 5 до 100 символів");
        softAssert.assertAll();
    }
}
