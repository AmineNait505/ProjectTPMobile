package com.example.projecttpmobile.controller;

import com.example.projecttpmobile.model.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<tasks> taskList;

    public TaskController() {
        // Initialize with fake data
        taskList = new ArrayList<>();
        taskList.add(new tasks("Task 1", "Description 1", false));
        taskList.add(new tasks("Task 2", "Description 2", true));
        taskList.add(new tasks("Task 3", "Description 3", false));
    }

    public List<tasks> getTaskList() {
        return taskList;
    }

    public void addTask(tasks task) {
        taskList.add(task);
    }
}