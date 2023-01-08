package com.ita.edu.speakua.jdbc.dao;

import com.ita.edu.speakua.jdbc.entity.ClubsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClubsDTO {

    public List<ClubsEntity> selectAll(){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_ALL);
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return ClubsEntity.getClubs(rows);
    }



}
