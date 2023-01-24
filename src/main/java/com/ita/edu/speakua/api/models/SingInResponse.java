package com.ita.edu.speakua.api.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SingInResponse {
    private int id;
    private String email;
    private String roleName;
    private String accessToken;
}
