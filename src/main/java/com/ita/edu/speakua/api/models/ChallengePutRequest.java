package com.ita.edu.speakua.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class ChallengePutRequest {

    private String name;
    private String title;
    private String description;
    // registrationLink must match https://docs.google.com/forms/d/e/{formCode}/viewform?embedded=true
    private String registrationLink;
    // picture Incorrect file path. It must be like /upload/*/*.png
    private String picture;
    private String sortNumber;
    private boolean isActive;
}
