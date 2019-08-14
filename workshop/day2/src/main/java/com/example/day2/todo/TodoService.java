package com.example.day2.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private TaskRepository taskRepository;

    @Autowired
    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> inquiryAll() {
        // Get data from repository
        List<Task> tasks = (List<Task>) taskRepository.findAll();

        // Map to response
        List<TaskResponse> results = new ArrayList<>();
        for (Task task: tasks) {
            results.add(new TaskResponse(task.getId(), task.getName()));
        }

        return results;
    }

}