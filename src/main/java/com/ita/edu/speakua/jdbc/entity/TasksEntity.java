package com.ita.edu.speakua.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TasksEntity {
    public static final String SELECT_FROM_TASKS_WHERE_NAME_IS = "SELECT * FROM tasks WHERE name = '%s';";
    public static final String SELECT_FROM_TASKS_WHERE_DESCRIPTION_IS = "SELECT * FROM tasks WHERE DESCRIPTION = '%s';";
    public static final String SELECT_ALL = "SELECT * FROM tasks;";

    private long challenge_id;
    private String description;
    private String header_text;
    private long id;
    private String name;
    private String picture;
    private String start_date;

    public static TasksEntity getTask(List<String> row) {
        TasksEntity task = new TasksEntity();
        task.setId(Long.parseLong(row.get(0)));
        task.setDescription(row.get(1));
        task.setHeader_text(row.get(2));
        task.setPicture(row.get(3));
        task.setName(row.get(4));
        if(row.get(5)!=null) {
            task.setChallenge_id(Long.parseLong(row.get(5)));
        }
        task.setStart_date(row.get(6));

        return task;
    }

    public static List<TasksEntity> getTasks(List<List<String>> rows) {
        List<TasksEntity> tasks = new ArrayList<>();
        for (List<String> row : rows) {
            tasks.add(getTask(row));
        }
        return tasks;
    }

}
