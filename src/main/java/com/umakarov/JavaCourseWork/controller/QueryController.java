package com.umakarov.JavaCourseWork.controller;

import com.umakarov.JavaCourseWork.dto.TaskDto;

import com.umakarov.JavaCourseWork.dto.UserDto;
import com.umakarov.JavaCourseWork.service.QueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(queryService.getAllUsers().getBody());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<List<UserDto>> getUsersByTaskId(@PathVariable Long id) {
        return ResponseEntity.ok(queryService.getUsersByTaskId(id).getBody());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(queryService.getUserById(id).getBody());
    }

    @GetMapping("tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(queryService.getAllTasks().getBody());
    }
    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(queryService.getTaskById(id).getBody());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(queryService.getTasksByUserId(id).getBody());
    }
}
