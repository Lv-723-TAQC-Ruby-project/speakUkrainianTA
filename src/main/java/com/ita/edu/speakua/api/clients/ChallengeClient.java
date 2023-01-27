package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.*;

public class ChallengeClient extends BaseClient {
    private String token;
    public ChallengeClient(){
        super();
    }
    public ChallengeClient(String token){
        super();
        this.token = token;
    }
    public ErrorResponse badPost(ChallengePostRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .post("/api/challenge")
                .as(ErrorResponse.class);
    }
    public ChallengePostResponse successPost(ChallengePostRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post("/api/challenge")
                .as(ChallengePostResponse.class);

    }
    public ErrorResponse unsuccessfulPut(ChallengePutRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/api/challenge/236")
                .as(ErrorResponse.class);
    }

    public ChallengeDeleteResponse successfulDelete(){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/api/challenge/409")
                .as(ChallengeDeleteResponse.class);
    }
}
