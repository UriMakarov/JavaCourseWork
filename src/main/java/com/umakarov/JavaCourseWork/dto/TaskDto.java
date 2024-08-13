package com.umakarov.JavaCourseWork.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    private Long id;
    private String description;
    public Date deadline;

}
