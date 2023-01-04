package com.ita.edu.speakua.jdbc.services;

import com.ita.edu.speakua.jdbc.dao.UsersDTO;
import com.ita.edu.speakua.jdbc.entity.UsersEntity;

import java.util.List;

public class UsersService {
    private final UsersDTO usersDTO;

    public UsersService() {
        this.usersDTO = new UsersDTO();
    }

    public List<UsersEntity> getAll() {
        return usersDTO.selectAll();
    }
    public UsersEntity getByEmail(String email) {
        return usersDTO.selectByEmail(email);
    }
}
