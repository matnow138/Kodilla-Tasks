package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskDtoTest {


    @Test
    public void taskDtoExists(){
        //Given
        TaskDto taskDto = new TaskDto(1L, "test title", "test content");
        //When

        //Then
        assertEquals(taskDto.getId(),1L);
        assertEquals(taskDto.getTitle(),"test title");
        assertEquals(taskDto.getContent(),"test content");
    }
}
