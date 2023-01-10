package com.ita.edu.speakua.jdbc.dao;

import com.ita.edu.speakua.jdbc.entity.TasksEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TasksDTO {
    public List<TasksEntity> selectAll(){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(TasksEntity.SELECT_ALL);
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);
        return TasksEntity.getTasks(rows);
    }

    public TasksEntity selectByName(String name){
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(TasksEntity.SELECT_FROM_TASKS_WHERE_NAME_IS, name));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ManagerDAO.closeStatement(statement);


        if(TasksEntity.getTasks(rows).size() == 0) {
            return null;
        }
        return TasksEntity.getTasks(rows).get(0);
    }
}

