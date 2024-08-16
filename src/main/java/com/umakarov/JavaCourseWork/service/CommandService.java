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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommandService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;


    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        Optional <User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setDepartment(userDto.getDepartment());

            return userMapper.toDto(
                    userRepository.save(user));
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        Optional <User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Optional <Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(taskDto.getDescription());
            task.setDeadline(taskDto.getDeadline());
            return taskMapper.toDto(
                    taskRepository.save(task));
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        Optional <Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            taskRepository.delete(task);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

}
