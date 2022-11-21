package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTestMvc {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskController taskController;

    @Test
    void getTasks() throws Exception {
        //Given
        List<TaskDto> taskDtoList = List.of(new TaskDto("Test title","test conent"));
        when(taskController.getTasks()).thenReturn(ResponseEntity.ok().body(taskDtoList));
        //When & Then
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                            .get("/v1/tasks")
                            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("Test title")));
    }

    @Test
    void searchTask() {
        //Given

        //When & Then

    }

    @Test
    void getTask() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void createTask() {
    }
}