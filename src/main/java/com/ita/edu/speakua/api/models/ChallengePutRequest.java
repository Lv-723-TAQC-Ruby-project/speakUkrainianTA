package com.ita.edu.speakua.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Jacksonized
public class ChallengePutRequest {
    private String name;
    private String title;
    private String description;
    // registrationLink must match https://docs.google.com/forms/d/e/{formCode}/viewform?embedded=true
    private String registrationLink;
    // picture Incorrect file path. It must be like /upload/*/*.png
    private String picture;
    private String sortNumber;
    @JsonProperty("isActive")
    private boolean isActive;
}
