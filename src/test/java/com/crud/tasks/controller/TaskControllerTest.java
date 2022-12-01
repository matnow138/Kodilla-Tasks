/* package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TaskControllerTest {

    @Autowired
    private TaskController taskController;

    @Autowired
    private DbService dbService;
    @Autowired
    private TaskRepository taskRepository;

    @AfterEach
    void cleanupDb() {
        taskRepository.deleteAll();
    }

    @Test
    public void getTasksTest() {
        //Given
        Task task = new Task("title", "content");

        //When
        dbService.saveTask(task);

        //Then
        List<TaskDto> taskDtoList = taskController.getTasks().getBody();

        assertEquals(task.getTitle(), taskDtoList.get(0).getTitle());
        assertEquals(task.getContent(), taskDtoList.get(0).getContent());
    }


    @Test
    public void searchTaskTest() throws TaskNotFoundException {
        //Given
        Task task = new Task("Titile", "Content");

        //When
        Task taskSave = dbService.saveTask(task);
        TaskDto taskDtoFound = taskController.searchTask(taskSave.getId()).getBody();
        //Then

        assertEquals(task.getTitle(), taskDtoFound.getTitle());
        assertEquals(task.getContent(), taskDtoFound.getContent());

    }

    @Test
    public void getTaskTest() throws TaskNotFoundException {
        //Given
        Task task = new Task("title", "content");
        //When
        Task savedTask = dbService.saveTask(task);
        TaskDto foundTask = taskController.getTask(savedTask.getId()).getBody();
        //Then

        assertEquals(savedTask.getId(), foundTask.getId());
        assertEquals(savedTask.getTitle(), savedTask.getTitle());
        assertEquals(savedTask.getContent(), savedTask.getContent());
    }

    @Test
    public void deleteTaskTest() throws TaskNotFoundException {
        //Given
        Task task = new Task("title", "content");
        //When
        Task savedTask = dbService.saveTask(task);
        taskController.deleteTask(savedTask.getId());
        //Then
    }

    @Test
    public void updateTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto("title", "content");

        //When
        TaskDto updatedTask = taskController.updateTask(taskDto).getBody();

        //Then
        assertEquals(taskDto.getTitle(), updatedTask.getTitle());
        assertEquals(taskDto.getContent(), updatedTask.getContent());
    }

    @Test
    public void createTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto("title", "content");
        //When
        taskController.createTask(taskDto);
        List<Task> taskList = dbService.getAllTasks();
        //Then
        assertEquals(taskList.get(0).getTitle(), taskDto.getTitle());
        assertEquals(taskList.get(0).getContent(), taskDto.getContent());
    }
}
*/