package com.umakarov.JavaCourseWork.service;

import com.umakarov.JavaCourseWork.dto.TaskDto;
import com.umakarov.JavaCourseWork.entity.Task;
import com.umakarov.JavaCourseWork.mapper.TaskMapper;
import com.umakarov.JavaCourseWork.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public TaskService(TaskMapper taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok(tasks.stream()
                .map(taskMapper::toDto)
                .toList());
    }
    public ResponseEntity<TaskDto> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}