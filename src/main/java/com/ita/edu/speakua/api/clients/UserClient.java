package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.User;

public class UserClient extends BaseClient{
    private String token;
    public UserClient(String token){
        super();
        this.token = token;}

    public ErrorResponse badPut(User response){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(response)
                .when()
                .put("/api/user/203")
                .as(ErrorResponse.class);
    }
}
