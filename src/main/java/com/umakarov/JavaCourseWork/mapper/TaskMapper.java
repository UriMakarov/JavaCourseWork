package com.umakarov.JavaCourseWork.mapper;

import com.umakarov.JavaCourseWork.dto.TaskDto;
import com.umakarov.JavaCourseWork.entity.Task;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);



    Task toEntity(TaskDto taskDto);
}
