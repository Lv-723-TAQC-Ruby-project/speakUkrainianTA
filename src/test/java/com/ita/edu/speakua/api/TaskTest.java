package com.ita.edu.speakua.api;

import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.clients.TaskClient;
import com.ita.edu.speakua.api.clients.UserClient;
import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.SingInRequest;
import com.ita.edu.speakua.api.models.SingInResponse;
import com.ita.edu.speakua.api.models.TaskPostRequest;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTest {
    protected static final ConfigProperties configProperties = new ConfigProperties();

    @Description("Task cannot be added with null fields")
    @Test
    public void unSucceedTaskAdding(){
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
        SingInResponse responseSI = clientSI.post(credential);
        TaskClient client = new TaskClient(responseSI.getAccessToken());
        TaskPostRequest requestBody = new TaskPostRequest("","","/upload/test/test.png", "2021-11-03");
        ErrorResponse response = client.unSucceedPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(),400);
     /*   softAssert.assertEquals(response.getMessage(),"startDate дата має бути в майбутньому and name must contain a minimum of 5 and a maximum of 100 letters" +
                " and headerText must not be blank and name must not be blank and description must contain a minimum of 40 and a maximum of 3000 letters");
    softAssert.assertEquals(response.getMessage(),"name must not be blank and name must contain a minimum of 5 and a maximum of 100 letters and description must contain a minimum of 40 and a maximum of 3000" +
                " letters and headerText must not be blank and startDate дата має бути в майбутньому");
        softAssert.assertEquals(response.getMessage(),"headerText must not be blank and description must contain a minimum of 40 and a maximum of 3000 letters and startDate дата має бути в майбутньому and name must contain " +
                "a minimum of 5 and a maximum of 100 letters and name must not be blank");*/

      TaskPostRequest  task = requestBody.toBuilder().build();
       task.setName("namenamena");
       task.setDescription("descriptiondescriptiondescriptiondescriptiondescription");
        response = client.unSucceedPost(task);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"headerText must not be blank and startDate дата має бути в майбутньому");

        task = requestBody.toBuilder().build();
       task.setName(null);
       task.setDescription(null);
        response = client.unSucceedPost(task);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(),"name must not be blank and startDate дата має бути в майбутньому and headerText must not be blank");


        softAssert.assertAll();
    }
}
