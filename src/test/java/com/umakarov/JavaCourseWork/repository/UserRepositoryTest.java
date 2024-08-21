package com.umakarov.JavaCourseWork.repository;

import com.umakarov.JavaCourseWork.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
public class UserRepositoryTest {
@Autowired
    private UserRepository userRepository;
    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setFirstName("Иван");
        testUser.setLastName("Иванов");
        testUser.setDepartment("Отдел продаж");
        userRepository.save(testUser);
    }

    @AfterEach
    public void tearDown() {
        userRepository.delete(testUser);
    }
    @Test
    void givenUser_whenSaved_thenCanBeFoundById() {
        User savedUser = userRepository.findById(testUser.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals(testUser.getFirstName(), savedUser.getFirstName());
        assertEquals(testUser.getLastName(), savedUser.getLastName());
        assertEquals(testUser.getDepartment(), savedUser.getDepartment());

    }
    @Test
    void givenUser_whenUpdated_thenCanBeFoundByIdWithUpdatedData() {
        testUser.setFirstName("updatedUsername");
        userRepository.save(testUser);

        User updatedUser = userRepository.findById(testUser.getId()).orElse(null);

        assertNotNull(updatedUser);
        assertEquals("updatedUsername", updatedUser.getFirstName());
    }
}