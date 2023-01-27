package com.ita.edu.speakua.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonArray;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Jacksonized
public class TaskResponse {
    private int id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private List<Integer> startDate;
    private int challengeId;

}
