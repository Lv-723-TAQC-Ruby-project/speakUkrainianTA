package com.ita.edu.speakua.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClubsEntity {
    public static final String SELECT_ALL = "SELECT * FROM clubs;";
    public static final String SELECT_FROM_CLUBS_WHERE_RATING = "";
    public static final String SELECT_FROM_CLUBS_WHERE_NAME = "SELECT name FROM public.clubs WHERE name like 'NAME_FROM_STEP1%';";

    private int ageFrom;
    private int ageTo;
    private long centerExternalId;
    private int centerId;
    private int clubExternalId;
    private String contacts;
    private String description;
    private int feedbackCount;
    private int id;
    private boolean isApproved;
    private boolean isOnline;
    private String name;
    private int rating;
    private String urlBackground;
    private String urlLogo;
    private String urlWeb;
    private int userId;
    private int workTime;

    public static ClubsEntity getClub(List<String> row) {
        ClubsEntity club = new ClubsEntity();

        club.setAgeFrom(Integer.parseInt(row.get(0)));
        club.setAgeTo(Integer.parseInt(row.get(1)));
        club.setCenterExternalId(Long.parseLong((row.get(2))));
        if (row.get(2) != null) {
            club.setCenterExternalId(Long.parseLong(row.get(2)));
        }
        club.setCenterId(Integer.parseInt(row.get(3)));
        club.setClubExternalId(Integer.parseInt(row.get(4)));
        club.setContacts(row.get(5));
        club.setDescription(row.get(6));
        club.setFeedbackCount(Integer.parseInt(row.get(7)));
        club.setId(Integer.parseInt(row.get(8)));
        club.setApproved(Boolean.parseBoolean(row.get(9)));
        club.setOnline(Boolean.parseBoolean(row.get(10)));
        club.setName(row.get(11));
        club.setRating(Integer.parseInt(row.get(12)));
        club.setUrlBackground(row.get(13));
        club.setUrlLogo(row.get(14));
        club.setUrlWeb(row.get(15));
        club.setUserId(Integer.parseInt(row.get(16)));
        club.setWorkTime(Integer.parseInt(row.get(17)));
        return club;
    }

    public static List<ClubsEntity> getClubs(List<List<String>> rows) {
        List<ClubsEntity> clubs = new ArrayList<>();
        for (List<String> row : rows) {
            clubs.add(getClub(row));
        }
        return clubs;
    }

}
