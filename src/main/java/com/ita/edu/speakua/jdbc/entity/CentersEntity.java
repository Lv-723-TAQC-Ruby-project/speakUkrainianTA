package com.ita.edu.speakua.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CentersEntity {
    public static final String SELECT_FROM_CENTERS_WHERE_NAME_IS = "SELECT * FROM centers WHERE name = '%s';";
    public static final String SELECT_ALL = "SELECT * FROM centers;";

    private long id;
    private long centerExternalId;
    private long clubCount;
    private String contacts;
    private String description;
    private String name;
    private double rating;
    private String urlBackgroundPicture;
    private String urlLogo;
    private String urlWeb;
    private long userId;

    public static CentersEntity getCenter(List<String> row) {
        CentersEntity center = new CentersEntity();

        center.setId(Long.parseLong(row.get(0)));

        if (row.get(1) != null) {
            center.setCenterExternalId(Long.parseLong(row.get(1)));
        }

        center.setContacts(row.get(2));
        center.setDescription(row.get(3));
        center.setName(row.get(4));

        if (row.get(5) != null) {
            center.setUrlBackgroundPicture(row.get(5));
        }

        if (row.get(6) != null) {
            center.setUrlLogo(row.get(6));
        }

        if (row.get(7) != null) {
            center.setUrlWeb(row.get(7));
        }

        if (row.get(8) != null) {
            center.setUserId(Long.parseLong(row.get(8)));
        }

        if (row.get(9) != null) {
            center.setClubCount(Long.parseLong(row.get(9)));
        }

        if (row.get(10) != null) {
            center.setRating(Double.parseDouble(row.get(9)));
        }
        return center;
    }

    public static List<CentersEntity> getCenters(List<List<String>> rows) {
        List<CentersEntity> centers = new ArrayList<>();
        for (List<String> row : rows) {
            centers.add(getCenter(row));
        }
        return centers;
    }
}