package com.umakarov.JavaCourseWork.controller;

import com.umakarov.JavaCourseWork.dto.TaskDto;
import com.umakarov.JavaCourseWork.dto.UserDto;
import com.umakarov.JavaCourseWork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers().getBody());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id).getBody());
    }

//    @GetMapping("{id}/tasks")
//    public ResponseEntity<List<TaskDto>> getTasksByUserId(@PathVariable Long id) {
//        return ResponseEntity.ok(userService.getTasksByUserId(id).getBody());
//    }

}
