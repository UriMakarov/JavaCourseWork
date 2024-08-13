package com.umakarov.JavaCourseWork.repository;

import com.umakarov.JavaCourseWork.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT t.id, t.description, t.deadline FROM tasks t, user_tasks ut WHERE t.id = ut.task_id AND ut.user_id = :userId", nativeQuery = true)
    List <Task>  getTasksByUserId(Long userId);

}
