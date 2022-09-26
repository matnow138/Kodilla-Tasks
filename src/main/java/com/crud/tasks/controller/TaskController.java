package com.crud.tasks.controller;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;

import com.crud.tasks.service.DbService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor

public class TaskController {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private DbService service;



   @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks(){
        List<Task> tasks = service.getAllTasks();
       return ResponseEntity.ok(taskMapper.mapToTaskDtoList(tasks));
    }
   @GetMapping(value ="/searchTask/{taskId}")
    public ResponseEntity<TaskDto> searchTask(@PathVariable Long taskId) throws TaskNotFoundException{

        return ResponseEntity.ok(taskMapper.mapToTaskDto(service.getTask(taskId)));

    }
    @GetMapping(value ="{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long taskId) throws TaskNotFoundException{

        return ResponseEntity.ok(taskMapper.mapToTaskDto(service.getTask(taskId)));

    }
    @DeleteMapping(value ="{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) throws TaskNotFoundException{
        service.deleteTask(taskId);
       return ResponseEntity.ok().build();

    }

    @PutMapping
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto){
       Task task = taskMapper.mapToTask(taskDto);
       Task savedTask = service.saveTask(task);
        return ResponseEntity.ok(taskMapper.mapToTaskDto(savedTask));

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto) {
       Task task = taskMapper.mapToTask(taskDto);
        service.saveTask(task);
       return ResponseEntity.ok().build();

    }


}
