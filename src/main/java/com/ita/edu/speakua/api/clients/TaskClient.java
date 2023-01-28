package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.TaskRequest;
import com.ita.edu.speakua.api.models.TaskResponse;

public class TaskClient extends BaseClient{
    private String token;
    public TaskClient(String token){
        super();
    this.token = token;}

    public ErrorResponse unSucceedPost(TaskRequest request){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post("/api/challenge/1/task")
                .as(ErrorResponse.class);
    }
    public TaskResponse successfulEditTask(TaskRequest request){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("api/challenge/task/202")
                .as(TaskResponse.class);
    }

    public ErrorResponse unsuccessfulPutTask(TaskRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/api/challenge/207")
                .as(ErrorResponse.class);
    }
}
