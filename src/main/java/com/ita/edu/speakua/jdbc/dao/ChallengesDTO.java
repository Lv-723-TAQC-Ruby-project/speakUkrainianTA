package com.ita.edu.speakua.jdbc.dao;

import com.ita.edu.speakua.jdbc.entity.ChallengesEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class ChallengesDTO {
    public List<ChallengesEntity> selectAll(){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ChallengesEntity.SELECT_ALL);
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return ChallengesEntity.getChallenges(rows);
    }

    public ChallengesEntity selectByName(String name){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ChallengesEntity.SELECT_FROM_CHALLENGES_WHERE_NAME_IS, name));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);

        if(rows.size() == 0) {
            return null;
        }
        return ChallengesEntity.getChallenges(rows).get(0);
    }

    public int getUniqueSortNumber(){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<Integer> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ChallengesEntity.SELECT_SORT_NUMBERS);
            rows = ManagerDAO.getInstance().parseResulColumn(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);

        if(rows.size() == 0) {
            return 0;
        }
        Collections.sort(rows);
        int lastNumber = rows.get(rows.size() - 1);
        return lastNumber+1;
    }
}
