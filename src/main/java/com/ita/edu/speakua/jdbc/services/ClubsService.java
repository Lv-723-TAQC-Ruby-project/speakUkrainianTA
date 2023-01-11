package com.ita.edu.speakua.jdbc.services;

import com.ita.edu.speakua.jdbc.dao.ClubsDTO;
import com.ita.edu.speakua.jdbc.entity.ClubsEntity;

import java.util.List;

public class ClubsService {
    private final ClubsDTO clubsDTO;

    public ClubsService() {
        this.clubsDTO = new ClubsDTO();
    }

    public List<ClubsEntity> getAll() {
        return clubsDTO.selectAll();
    }

    public List<ClubsEntity> getByRatingASC() {
        return clubsDTO.checkRatingASC();
    }

    public List<ClubsEntity> getByRatingDSC() {
        return clubsDTO.checkRatingDSC();
    }

    public ClubsEntity getByName(String name) {
        return clubsDTO.selectWhereClubName(name);
    }

    public ClubsEntity getWhereCityName(String cityName) {

        return clubsDTO.selectClubWhereCityName(cityName);
    }

}
