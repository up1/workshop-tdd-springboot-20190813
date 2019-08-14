package com.example.day2.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/todos")
    public TaskResponseList getAll() {
        List<TaskResponse> tasks = new ArrayList<>();
        tasks.add(new TaskResponse(1, "Task 1"));
        tasks.add(new TaskResponse(2, "Task 2"));

        TaskResponseList results = new TaskResponseList();
        results.setTasks(tasks);
        return results;
    }

}
