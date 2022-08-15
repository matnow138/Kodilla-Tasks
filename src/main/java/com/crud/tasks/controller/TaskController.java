package com.crud.tasks.controller;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;

import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private DbService service;



   @GetMapping
    public List<TaskDto> getTasks(){
        List<Task> tasks = service.getAllTasks();
       return taskMapper.mapToTaskDtoList(tasks);
    }
   @GetMapping(value ="/searchTask/{taskId}")
    public TaskDto searchTask(@PathVariable Long taskId){
       Optional<Task> task = service.findById(taskId);

       return task.map(taskMapper::mapToTaskDto).orElse(new TaskDto());
    }
    @GetMapping(value ="{taskId}")
    public TaskDto getTask(@PathVariable Long taskId){

       return new TaskDto(1L, "test title", "test_content");
    }
    @DeleteMapping(value ="{taskId}")
    public void deleteTask(@PathVariable Long taskId){

    }

    @PutMapping(value ="{taskId}")
    public TaskDto updateTask(@RequestBody @PathVariable Long taskId, TaskDto taskDto){
        return new TaskDto(1L, "Edited test title", "Test content");
    }
    @PostMapping
    public void createTask(@RequestBody TaskDto taskDto) {

    }

}
