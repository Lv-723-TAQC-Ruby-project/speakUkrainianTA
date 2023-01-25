package com.ita.edu.speakua.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String roleName;
    private String urlLogo;
    private Boolean status;
}