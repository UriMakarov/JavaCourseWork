package com.umakarov.JavaCourseWork.repository;

import com.umakarov.JavaCourseWork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Long> {
}
