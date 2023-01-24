package com.ita.edu.speakua.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChallengPostRequest {

    private String name;
    private String title;
    private String description;
    // registrationLink must match https://docs.google.com/forms/d/e/{formCode}/viewform?embedded=true
    private String registrationLink;
    // picture Incorrect file path. It must be like /upload/*/*.png
    private String picture;
    private int sortNumber;
}
