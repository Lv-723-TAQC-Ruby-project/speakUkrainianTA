package com.ita.edu.speakua.jdbc.services;

import com.ita.edu.speakua.jdbc.dao.TasksDTO;
import com.ita.edu.speakua.jdbc.entity.TasksEntity;

import java.util.List;

public class TasksService {
    private final TasksDTO tasksDTO;

    public TasksService() {
        this.tasksDTO = new TasksDTO();
    }

    public List<TasksEntity> getAll() {
        return tasksDTO.selectAll();
    }
    public TasksEntity getByName(String name) {
        return tasksDTO.selectByName(name);
    }
}
