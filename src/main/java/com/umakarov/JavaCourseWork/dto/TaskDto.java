package com.umakarov.JavaCourseWork.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class TaskDto {
    private Long id;
    private String description;
    private Date deadline;
    private List<UserDto> users;
}
