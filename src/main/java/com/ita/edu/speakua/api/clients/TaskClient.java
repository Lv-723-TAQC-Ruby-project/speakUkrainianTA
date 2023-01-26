package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.TaskPostRequest;

public class TaskClient extends BaseClient{
    private String token;
    public TaskClient(String token){
        super();
    this.token = token;}

    public ErrorResponse unSucceedPost(TaskPostRequest response){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(response)
                .when()
                .post("/api/challenge/1/task")
                .as(ErrorResponse.class);
    }
}
