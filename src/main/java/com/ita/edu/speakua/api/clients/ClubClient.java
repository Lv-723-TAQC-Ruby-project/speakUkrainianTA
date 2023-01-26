package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ClubPostRequest;
import com.ita.edu.speakua.api.models.ClubPostResponse;

public class ClubClient extends BaseClient {
    private String token;
    public ClubClient() {
        super();
    }

    public ClubClient(String token) {
        super();
        this.token = token;
    }

    public ClubPostResponse post(ClubPostRequest request) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl + "/api/club")
                .as(ClubPostResponse.class);
    }

}

