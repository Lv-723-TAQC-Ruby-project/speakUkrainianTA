package com.ita.edu.speakua.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingInRequest {
    String email;
    String password;
}
