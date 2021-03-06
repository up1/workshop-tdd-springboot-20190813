package com.example.day2.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoControllerSpringBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void success_with_getAll() {
        // Arrange
        taskRepository.save(new Task("Task 1"));
        taskRepository.save(new Task("Task 2"));

        // Act
        TaskResponseList response =
                restTemplate.getForObject("/todos", TaskResponseList.class);

        // Assert
        assertEquals(2, response.getResults().size());

        TaskResponse task1 = response.getResults().get(0);
        assertEquals(1, task1.getId());
        assertEquals("Task 1", task1.getName());

        taskRepository.deleteAll();
    }
}