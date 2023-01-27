package com.ita.edu.speakua.api.clients;

import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.UserRequest;
import com.ita.edu.speakua.api.models.UserResponse;

public class UserClient extends BaseClient{
    private String token;
    public UserClient(String token){
        super();
        this.token = token;}

    public ErrorResponse badPut(UserRequest response){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(response)
                .when()
                .put("/api/user/203")
                .as(ErrorResponse.class);
    }

    public UserResponse successfulChanges(UserRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/api/user/1")
                .as(UserResponse.class);

    }
}
