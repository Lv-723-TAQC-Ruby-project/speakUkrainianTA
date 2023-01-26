package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ChallengePostRequest;
import com.ita.edu.speakua.api.models.ChallengePostResponse;
import com.ita.edu.speakua.api.models.ChallengePutRequest;
import com.ita.edu.speakua.api.models.ErrorResponse;

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
}
