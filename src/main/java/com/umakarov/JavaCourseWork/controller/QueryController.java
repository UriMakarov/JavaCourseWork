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
    @GetMapping("/users/{taskId}")
    public ResponseEntity<List<UserDto>> getUsersByTaskId(@PathVariable Long taskId) {
        return ResponseEntity.ok(queryService.getUsersByTaskId(taskId).getBody());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return queryService.getUserById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(queryService.getAllTasks().getBody());
    }
    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return queryService.getTaskById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tasks/{userId}")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(queryService.getTasksByUserId(userId).getBody());
    }
}
