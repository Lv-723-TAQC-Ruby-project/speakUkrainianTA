package com.ita.edu.speakua.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClubsEntity {
    public static final String SELECT_ALL = "SELECT * FROM clubs;";
    public static final String SELECT_FROM_CLUBS_WHERE_NAME = "SELECT * FROM clubs WHERE name = '%s';";

    public static final String SELECT_FROM_CLUBS_WHERE_CITY_NAME = "SELECT * FROM clubs as cl JOIN locations l ON cl.id = l.club_id JOIN cities ct ON l.city_id = ct.id WHERE ct.name = '%s';";
    public static final String SELECT_NAME_RATING_FROM_CLUBS_WHERE_ORDER_ASC = "SELECT * FROM clubs WHERE id IN (SELECT DISTINCT club_category.club_id FROM club_category) ORDER BY rating ASC, id;";
    public static final String SELECT_NAME_RATING_FROM_CLUBS_WHERE_ORDER_DSC = "SELECT * FROM clubs WHERE id IN (SELECT DISTINCT club_category.club_id FROM club_category) ORDER BY rating DESC, id;";

    private int id;
    private int age_from;
    private int age_to;
    private long center_external_id;
    private int club_external_id;
    private String contacts;
    private String description;
    private boolean is_approved;
    private boolean is_online;
    private String name;
    private double rating;
    private String url_background;
    private String url_logo;
    private String url_web;
    private int work_time;
    private int center_id;
    private int user_id;
    private int feedback_count;

    public static ClubsEntity getClub(List<String> row) {
        ClubsEntity club = new ClubsEntity();

        if (row.get(0) != null) {
            club.setId(Integer.parseInt(row.get(0)));
        }
        club.setAge_from(Integer.parseInt(row.get(1)));
        club.setAge_to(Integer.parseInt(row.get(2)));
        if (row.get(3) != null) {
            club.setCenter_external_id(Long.parseLong(row.get(3)));
        }
        if (row.get(4) != null) {
            club.setClub_external_id(Integer.parseInt(row.get(4)));
        }
        if (row.get(5) != null) {
            club.setContacts(row.get(5));
        }
        club.setDescription(row.get(6));
        club.set_approved(Boolean.parseBoolean(row.get(7)));
        club.set_online(Boolean.parseBoolean(row.get(8)));
        if (row.get(9) != null) {
            club.setName(row.get(9));
        }
        if (row.get(10) != null) {
            club.setRating(Double.parseDouble(row.get(10)));
        }
        if (row.get(11) != null) {
            club.setUrl_background(row.get(11));
        }
        if (row.get(12) != null) {
            club.setUrl_logo(row.get(12));
        }
        if (row.get(13) != null) {
            club.setUrl_web(row.get(13));
        }
        if (row.get(14) != null) {
            club.setWork_time(Integer.parseInt(row.get(14)));
        }
        if (row.get(15) != null) {
            club.setCenter_id(Integer.parseInt(row.get(15)));
        }
        if (row.get(16) != null) {
            club.setUser_id(Integer.parseInt(row.get(16)));
        }
        if (row.get(17) != null) {
            club.setFeedback_count(Integer.parseInt(row.get(17)));
        }
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
