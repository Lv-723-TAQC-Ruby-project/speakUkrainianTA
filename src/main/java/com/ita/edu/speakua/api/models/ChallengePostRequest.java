package com.ita.edu.speakua.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ChallengePostRequest {

    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private Integer sortNumber;
}
