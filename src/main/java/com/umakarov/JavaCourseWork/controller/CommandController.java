package com.umakarov.JavaCourseWork.controller;

import com.umakarov.JavaCourseWork.dto.TaskDto;
import com.umakarov.JavaCourseWork.dto.UserDto;
import com.umakarov.JavaCourseWork.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command")
@RequiredArgsConstructor
public class CommandController {

    private final CommandService commandService;
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        return ResponseEntity.ok(commandService.createUser(userDto));
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(commandService.updateUser(id, userDto));

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        commandService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> createTask(TaskDto taskDto) {
        return ResponseEntity.ok(commandService.createTask(taskDto));
    }
    @PostMapping("/usertasks/{userId}/{taskId}")
    public ResponseEntity<Object> createUserTask(@PathVariable Long userId, @PathVariable Long taskId) {
        Object result = commandService.assignUserToTask(userId, taskId);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(commandService.updateTask(id, taskDto));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        commandService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/usertasks/{userId}/{taskId}")
    public ResponseEntity<Void> removeTaskFromUser(@PathVariable Long userId, @PathVariable Long taskId) {
        commandService.removeTaskFromUser(userId, taskId);
        return ResponseEntity.ok().build();
    }



}
