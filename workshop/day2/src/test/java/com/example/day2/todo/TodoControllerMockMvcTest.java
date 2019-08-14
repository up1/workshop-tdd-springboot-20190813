package com.example.day2.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void success_with_getAll() throws Exception {
        // Arrange
        List<TaskResponse> stubs = new ArrayList<>();
        stubs.add(new TaskResponse(1, "Mock 1"));
        stubs.add(new TaskResponse(2, "Mock 2"));
        given(todoService.inquiryAll()).willReturn(stubs);

        // Act
        MvcResult result = mvc.perform(get("/todos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        // Convert string to object
        String json
                =result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        TaskResponseList response
                = mapper.readValue(json, TaskResponseList.class);

        // Assert
        assertEquals(2, response.getResults().size());

        TaskResponse task1 = response.getResults().get(0);
        assertEquals(1, task1.getId());
        assertEquals("Mock 1", task1.getName());
    }
}