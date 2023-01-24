package com.ita.edu.speakua.api.models;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
}
