package com.example.registrationdemo.dao;

import com.example.registrationdemo.entities.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private static UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao();
        System.out.println("Before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @BeforeAll
    static void setUpAll() {
        System.out.println("Before all");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all");
    }

    @Test
    @DisplayName("SaveTest")
    @Order(1)
    void save() {
        System.out.println("Test save");
    }

    @Test
    @Order(2)
    void update() {
        System.out.println("Test update");
    }

    @Test
    @Order(2)
    void select() {
        System.out.println("Test select");
    }

    @Test
    @Order(2)
    void getAll() {
        System.out.println("Test getAll");
    }

    @Test
    @Disabled
    @Order(3)
    void delete() {
        System.out.println("Test delete");
    }

    @Test
    void findUserByEmailAndPassword() {
        System.out.println("Test findUserByEmailAndPassword");
    }
}