package com.ita.edu.speakua.jdbc.dao;

import com.ita.edu.speakua.jdbc.entity.CentersEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CentersDTO {
    public List<CentersEntity> selectAll(){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(CentersEntity.SELECT_ALL);
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return CentersEntity.getCenters(rows);
    }
    public CentersEntity selectByName(String name){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(CentersEntity.SELECT_FROM_CENTERS_WHERE_NAME_IS, name));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);

        if(CentersEntity.getCenters(rows).size() == 0) {
            return null;
        }
        return CentersEntity.getCenters(rows).get(0);
    }

}
