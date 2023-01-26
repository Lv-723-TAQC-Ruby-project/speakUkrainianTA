package com.ita.edu.speakua.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ChallengesEntity {
    public static final String SELECT_FROM_CHALLENGES_WHERE_NAME_IS = "SELECT * FROM challenges WHERE name = '%s';";
    public static final String SELECT_FROM_CHALLENGES_WHERE_DESCRIPTION_IS = "SELECT * FROM challenges WHERE DESCRIPTION = '%s';";
    public static final String SELECT_ALL = "SELECT * FROM challenges;";

    public static final String SELECT_SORT_NUMBERS = "SELECT sort_number FROM challenges;";

    private long id;
    private String description;
    private boolean is_active;
    private String name;
    private String picture;
    private String registration_link;
    private long sort_number;
    private String title;
    private long user_id;

    public static ChallengesEntity getChallenge(List<String> row) {
        ChallengesEntity challenge = new ChallengesEntity();
        challenge.setId(Long.parseLong(row.get(0)));
        challenge.setDescription(row.get(1));
        challenge.set_active(Boolean.parseBoolean(row.get(2)));
        challenge.setName(row.get(3));
        challenge.setPicture(row.get(4));
        challenge.setRegistration_link(row.get(5));
        challenge.setSort_number(Long.parseLong(row.get(6)));
        challenge.setTitle(row.get(7));
        challenge.setUser_id(Long.parseLong(row.get(8)));
        return challenge;
    }
    public static List<ChallengesEntity> getChallenges(List<List<String>> rows) {
        List<ChallengesEntity> challenges = new ArrayList<>();
        for (List<String> row : rows) {
            challenges.add(getChallenge(row));
        }
        return challenges;
    }
}
