package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ChallengPostRequest;
import com.ita.edu.speakua.api.models.ChallengePostResponse;
import com.ita.edu.speakua.api.models.ErrorResponse;
import io.restassured.response.Response;

public class ChallengeClient extends BaseClient {
    private String token;
    public ChallengeClient(){
        super();
    }
    public ChallengeClient(String token){
        super();
        this.token = token;
    }
    public ErrorResponse badPost(ChallengPostRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .post("/api/challenge")
                .as(ErrorResponse.class);
    }
    public ChallengePostResponse successPost(ChallengPostRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post("/api/challenge")
                .as(ChallengePostResponse.class);
    }
}
