package com.umakarov.JavaCourseWork.service;

import com.umakarov.JavaCourseWork.dto.UserDto;
import com.umakarov.JavaCourseWork.entity.User;
import com.umakarov.JavaCourseWork.repository.UserRepository;
import com.umakarov.JavaCourseWork.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users.stream()
                .map(userMapper::toDto)
                .toList());
    }

}
