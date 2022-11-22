package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.google.gson.Gson;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

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
    void searchTask() throws Exception{
        //Given
        TaskDto taskDto = new TaskDto("title","content");
        when(taskController.searchTask(anyLong())).thenReturn(ResponseEntity.ok().body(taskDto));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks/searchTask/{taskId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("content")));

    }

    @Test
    void getTask() throws Exception{
        //Given
        TaskDto taskDto = new TaskDto("title","content");
        when(taskController.getTask(anyLong())).thenReturn(ResponseEntity.ok().body(taskDto));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks/{taskId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("content")));
    }

    @Test
    void deleteTask() throws Exception {
        //Given

        //When & Then
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .delete("/v1/tasks/{taskId}", 1L)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void updateTask() throws Exception{
        //Given
        Gson gson = new Gson();
        TaskDto taskDto = new TaskDto("title","content");
        TaskDto updatedTaskDto = new TaskDto("new title","new content");
        when(taskController.updateTask(any(TaskDto.class))).thenReturn(ResponseEntity.ok().body(updatedTaskDto));
        String json = gson.toJson(taskDto);
        //When & Then
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .put("/v1/tasks/")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .characterEncoding("UTF-8")
                                .content(json))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("new title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("new content")));
    }

    @Test
    void createTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto("title","content");
        Gson gson = new Gson();
        String json = gson.toJson(taskDto);
        //When & Then
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/v1/tasks")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                                .content(json))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}