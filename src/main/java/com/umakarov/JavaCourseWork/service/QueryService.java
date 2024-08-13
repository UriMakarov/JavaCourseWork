package com.umakarov.JavaCourseWork.service;

import com.umakarov.JavaCourseWork.dto.TaskDto;
import com.umakarov.JavaCourseWork.dto.UserDto;
import com.umakarov.JavaCourseWork.entity.Task;
import com.umakarov.JavaCourseWork.entity.User;
import com.umakarov.JavaCourseWork.mapper.TaskMapper;
import com.umakarov.JavaCourseWork.mapper.UserMapper;
import com.umakarov.JavaCourseWork.repository.TaskRepository;
import com.umakarov.JavaCourseWork.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QueryService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok(tasks.stream()
                .map(taskMapper::toDto)
                .toList());
    }
    public Optional<TaskDto> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto);
    }

    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users.stream()
                .map(userMapper::toDto)
                .toList());
    }

    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto);
    }
    public ResponseEntity<List<TaskDto>> getTasksByUserId(Long id) {
        List<Task> tasks = taskRepository.getTasksByUserId(id);
        List<TaskDto> taskDto = tasks.stream()
                .map(taskMapper::toDto).toList();

        return ResponseEntity.ok(taskDto);
    }

    public ResponseEntity<List<UserDto>> getUsersByTaskId(Long id) {
        List<User> users = userRepository.getUsersByTaskId(id);
        List<UserDto> userDto = users.stream()
                .map(userMapper::toDto).toList();
        return ResponseEntity.ok(userDto);
    }
}
