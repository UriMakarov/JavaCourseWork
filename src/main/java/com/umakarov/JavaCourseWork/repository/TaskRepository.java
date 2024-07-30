package com.umakarov.JavaCourseWork.repository;

import com.umakarov.JavaCourseWork.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
