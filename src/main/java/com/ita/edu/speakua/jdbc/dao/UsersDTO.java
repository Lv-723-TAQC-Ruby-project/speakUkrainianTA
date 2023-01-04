package com.ita.edu.speakua.jdbc.dao;

import com.ita.edu.speakua.jdbc.entity.UsersEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsersDTO {
    public List<UsersEntity> selectAll(){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(UsersEntity.SELECT_ALL);
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return UsersEntity.getUsers(rows);
    }
    public UsersEntity selectByEmail(String email){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(UsersEntity.SELECT_FROM_USERS_WHERE_EMAIL_IS, email));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);

        if(UsersEntity.getUsers(rows).size() == 0) {
            return null;
        }
        return UsersEntity.getUsers(rows).get(0);
    }

}
