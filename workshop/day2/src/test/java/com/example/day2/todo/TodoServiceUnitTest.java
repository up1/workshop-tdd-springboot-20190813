package com.example.day2.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceUnitTest {

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void success_inquiryAll() {
        // Arrange
        List<Task> stubs = new ArrayList<>();
        stubs.add(new Task(1, "Mock 1"));
        stubs.add(new Task(2, "Mock 2"));
        given(taskRepository.findAll()).willReturn(stubs);

        // Act
        TodoService todoService = new TodoService(taskRepository);
        List<TaskResponse> responses = todoService.inquiryAll();

        // Assert
        TaskResponse task1 = responses.get(0);
        assertEquals(1, task1.getId());
        assertEquals("Mock 1", task1.getName());
    }
}