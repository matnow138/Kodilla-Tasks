/* package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    TaskRepository repository;
    @Autowired
    private DbService dbService;

    @AfterEach
    void cleanupDb() {
        repository.deleteAll();
    }


    @Test
    public void findByIdTest() throws TaskNotFoundException {
        //Given
        Task task = new Task("Title", "Content");
        Task savedTask = dbService.saveTask(task);

        //When
        Task foundTask = dbService.findById(savedTask.getId()).orElse(null);

        //Then
        assertNotNull(foundTask);
        assertEquals(foundTask.getTitle(), task.getTitle());
    }

    @Test
    public void getAllTasksTest() {
        //Given
        Task task = (new Task("title", "content"));

        //When
        dbService.saveTask(task);
        List<Task> foundTasks = dbService.getAllTasks();
        //Then

        assertEquals(foundTasks.get(0).getTitle(), task.getTitle());
        assertEquals(foundTasks.get(0).getContent(), task.getContent());
    }


}

 */
