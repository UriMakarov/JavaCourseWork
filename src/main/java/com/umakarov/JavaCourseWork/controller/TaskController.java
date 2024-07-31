package com.umakarov.JavaCourseWork.controller;

import com.umakarov.JavaCourseWork.dto.TaskDto;
import com.umakarov.JavaCourseWork.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks().getBody());
    }
    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id).getBody());
    }
}
