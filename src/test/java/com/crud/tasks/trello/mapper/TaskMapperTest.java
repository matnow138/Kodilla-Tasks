package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;
    @Test
    public void mapToTaskTest(){
        //Given
        TaskDto taskDto = new TaskDto( "Test title", "Test content" );

        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(task.getTitle(), "Test title");
        assertEquals(task.getContent(), "Test content");
    }
    @Test
    public void mapToTaskDtoTest(){
        //Given
        Task task = new Task("Test title", "Test content" );

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then

        assertEquals(taskDto.getTitle(), "Test title");
        assertEquals(taskDto.getContent(), "Test content");
    }
    @Test
    public void mapToTaskDtoListTest(){
        //Given
        Task task = new Task("Test title", "Test content" );
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then

        assertEquals(taskDtoList.get(0).getTitle(), "Test title");
        assertEquals(taskDtoList.get(0).getContent(), "Test content");
    }
}
