package com.example.projecttpmobile.model;

public class tasks {
    private String title;
    private String description;
    private boolean completed;

    public tasks(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
}

