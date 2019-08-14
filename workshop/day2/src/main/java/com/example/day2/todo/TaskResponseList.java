package com.example.day2.todo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public class TaskResponseList {

    private List<TaskResponse> tasks;

    @JsonValue
    public List<TaskResponse> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskResponse> tasks) {
        this.tasks = tasks;
    }
}
