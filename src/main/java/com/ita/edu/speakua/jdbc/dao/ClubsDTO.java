package com.ita.edu.speakua.jdbc.dao;

import com.ita.edu.speakua.jdbc.entity.ClubsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClubsDTO {

    public List<ClubsEntity> selectAll() {
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

    public List<ClubsEntity> checkRatingASC() {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_NAME_RATING_FROM_CLUBS_WHERE_ORDER_ASC);
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return ClubsEntity.getClubs(rows);
    }

    public List<ClubsEntity> checkRatingDSC() {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_NAME_RATING_FROM_CLUBS_WHERE_ORDER_DSC);
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return ClubsEntity.getClubs(rows);
    }

    public List<ClubsEntity> selectClubWhereCityName(String cityName) {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ClubsEntity.SELECT_FROM_CLUBS_WHERE_CITY_NAME, cityName));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return ClubsEntity.getClubs(rows);
    }

    public List<ClubsEntity> selectWhereClubName(String clubName) {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ClubsEntity.SELECT_FROM_CLUBS_WHERE_NAME, clubName));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return ClubsEntity.getClubs(rows);
    }

}
