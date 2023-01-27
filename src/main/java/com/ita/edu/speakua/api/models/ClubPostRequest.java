package com.ita.edu.speakua.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClubPostRequest {
    private int id = 0;
    private String name;
    private String description;
    private int centerId = 0;
    private List<String> categoriesName;
    private List<Location> locations;
    private int ageFrom;
    private int ageTo;
    private String urlBackground;
    private String urlLogo;
    private List<String> urlGallery;
    private boolean isOnline = true;
    private String contacts;
    private boolean isApproved = true;
    private int userId;
    private int clubExternalId = 0;
    private int centerExternalId = 0;
}
