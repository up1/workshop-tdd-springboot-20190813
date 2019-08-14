package com.example.day2.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    public List<TaskResponse> inquiryAll() {
        List<TaskResponse> tasks = new ArrayList<>();
        tasks.add(new TaskResponse(1, "Task 1"));
        tasks.add(new TaskResponse(2, "Task 2"));

        return tasks;
    }

}