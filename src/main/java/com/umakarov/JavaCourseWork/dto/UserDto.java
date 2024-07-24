package com.umakarov.JavaCourseWork.dto;

import com.umakarov.JavaCourseWork.entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Task> tasks;
}
