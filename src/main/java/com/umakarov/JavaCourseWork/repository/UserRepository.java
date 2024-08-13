package com.umakarov.JavaCourseWork.repository;


import com.umakarov.JavaCourseWork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository  extends JpaRepository <User, Long> {
    @Query(nativeQuery = true
            , value = "SELECT u.id, u.first_name, u.last_name, u.department " +
            "FROM users u, user_tasks ut WHERE u.id = ut.user_id AND ut.task_id = :taskId")
    List<User> getUsersByTaskId(Long taskId);
}
