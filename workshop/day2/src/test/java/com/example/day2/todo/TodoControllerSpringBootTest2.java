package com.example.day2.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoControllerSpringBootTest2 {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void success_with_getAll() {
        // Arrange
        List<Task> stubs = new ArrayList<>();
        stubs.add(new Task(1, "Mock 1"));
        stubs.add(new Task(2, "Mock 2"));
        given(taskRepository.findAll()).willReturn(stubs);

        // Act
        TaskResponseList response =
                restTemplate.getForObject("/todos", TaskResponseList.class);

        // Assert
        assertEquals(2, response.getResults().size());

        TaskResponse task1 = response.getResults().get(0);
        assertEquals(1, task1.getId());
        assertEquals("Mock 1", task1.getName());

        taskRepository.deleteAll();
    }
}