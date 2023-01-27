package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ChallengePostRequest;
import com.ita.edu.speakua.api.models.ClubPostRequest;
import com.ita.edu.speakua.api.models.ClubPostResponse;
import com.ita.edu.speakua.api.models.ErrorResponse;

public class ClubClient extends BaseClient {
    private String token;
    public ClubClient() {
        super();
    }

    public ClubClient(String token) {
        super();
        this.token = token;
    }

    public ClubPostResponse successPost(ClubPostRequest request) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl + "/api/club")
                .as(ClubPostResponse.class);
    }

    public ErrorResponse badPost(ClubPostRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl + "/api/club")
                .as(ErrorResponse.class);
    }

}

