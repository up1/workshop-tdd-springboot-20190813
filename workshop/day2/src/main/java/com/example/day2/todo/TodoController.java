package com.example.day2.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public TaskResponseList getAll() {
        List<TaskResponse> tasks = todoService.inquiryAll();

        TaskResponseList results = new TaskResponseList();
        results.setCode(200);
        results.setDescription("ok");
        results.setResults(tasks);
        return results;
    }

}
