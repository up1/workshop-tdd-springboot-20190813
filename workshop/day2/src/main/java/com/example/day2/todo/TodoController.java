package com.example.day2.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/todos")
    public List<TaskResponse> getAll() {
        List<TaskResponse> results = new ArrayList<>();
        results.add(new TaskResponse(1, "Task 1"));
        return results;
    }

}
