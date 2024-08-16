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

    @Query(nativeQuery = true,
        value = "INSERT INTO user_tasks (user_id, task_id) VALUES (:userId, :taskId) returning user_id")
    void assignTaskToUser(Long userId, Long taskId);
    @Query(nativeQuery = true, value = """
        SELECT EXISTS (SELECT 1 FROM users WHERE id = :userId)
        AND EXISTS (SELECT 1 FROM tasks WHERE id = :taskId)
        AND NOT EXISTS (SELECT 1 FROM user_tasks WHERE user_id = :userId AND task_id = :taskId)""")
    boolean checkUserTask(Long userId, Long taskId);

    @Query(nativeQuery = true,
        value = "DELETE from user_tasks  WHERE user_id = :userId AND task_id = :taskId returning user_id")
    void removeTaskFromUser(Long userId, Long taskId);

    @Query(nativeQuery = true, value = """
    SELECT u.id
    FROM users u
    LEFT JOIN user_tasks tu ON u.id = tu.user_id
    LEFT JOIN tasks t ON tu.task_id = t.id
    GROUP BY u.id
    ORDER BY COUNT(tu.task_id)
    LIMIT 1""")
    Long getUserIdWithMinTasksCount();
}

//users with task_count
//    SELECT u.id, u.first_name, u.last_name, u.department, COUNT(ut.task_id) AS task_count
//        FROM users u
//        LEFT JOIN user_tasks ut ON u.id = ut.user_id
//        LEFT JOIN tasks t ON ut.task_id = t.id
//        GROUP BY u.id, u.first_name, u.last_name, u.department