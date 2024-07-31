package com.umakarov.JavaCourseWork.service;

import com.umakarov.JavaCourseWork.dto.TaskDto;
import com.umakarov.JavaCourseWork.dto.UserDto;
import com.umakarov.JavaCourseWork.entity.Task;
import com.umakarov.JavaCourseWork.entity.User;
import com.umakarov.JavaCourseWork.mapper.TaskMapper;
import com.umakarov.JavaCourseWork.repository.TaskRepository;
import com.umakarov.JavaCourseWork.repository.UserRepository;
import com.umakarov.JavaCourseWork.mapper.UserMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;


    public UserService(UserMapper userMapper, UserRepository userRepository, TaskRepository taskRepository, TaskMapper taskMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }
//    public UserService() {
//        this(null, null, null, null);
//    }

    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users.stream()
                .map(userMapper::toDto)
                .toList());
    }

    public ResponseEntity<UserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<List<TaskDto>> getTasksByUserId(Long id) {
        List<Task> tasks = taskRepository.getTasksByUserId(id);
        List<TaskDto> taskDto = tasks.stream()
                .map(taskMapper::toDto).toList();

        return ResponseEntity.ok(taskDto);
    }

}


