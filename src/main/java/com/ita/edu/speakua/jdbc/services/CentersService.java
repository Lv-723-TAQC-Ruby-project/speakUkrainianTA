package com.ita.edu.speakua.jdbc.services;

import com.ita.edu.speakua.jdbc.dao.CentersDTO;
import com.ita.edu.speakua.jdbc.dao.UsersDTO;
import com.ita.edu.speakua.jdbc.entity.CentersEntity;
import com.ita.edu.speakua.jdbc.entity.UsersEntity;

import java.util.List;

public class CentersService {
    private final CentersDTO centersDTO;

    public CentersService() {
        this.centersDTO = new CentersDTO();
    }

    public List<CentersEntity> getAll() {
        return centersDTO.selectAll();
    }
    public CentersEntity getByName(String name) {
        return centersDTO.selectByName(name);
    }
}