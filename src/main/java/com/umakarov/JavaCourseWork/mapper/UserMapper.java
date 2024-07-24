package com.umakarov.JavaCourseWork.mapper;

import com.umakarov.JavaCourseWork.dto.UserDto;
import com.umakarov.JavaCourseWork.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
