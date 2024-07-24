package com.umakarov.JavaCourseWork.repository;

import com.umakarov.JavaCourseWork.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(Long userId);
}