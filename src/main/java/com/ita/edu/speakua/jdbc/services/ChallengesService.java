package com.ita.edu.speakua.jdbc.services;

import com.ita.edu.speakua.jdbc.dao.ChallengesDTO;

import com.ita.edu.speakua.jdbc.entity.ChallengesEntity;
import java.util.List;

public class ChallengesService {
    private final ChallengesDTO challengesDTO;

    public ChallengesService() {
        this.challengesDTO = new ChallengesDTO();
    }

    public List<ChallengesEntity> getAll() {
        return challengesDTO.selectAll();
    }
    public ChallengesEntity getByName(String name) {
        return challengesDTO.selectByName(name);
    }

    public int getUniqueNumber() {
        return challengesDTO.getUniqueSortNumber();
    }

}

