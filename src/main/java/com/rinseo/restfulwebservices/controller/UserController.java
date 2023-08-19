package com.rinseo.restfulwebservices.controller;


import com.rinseo.restfulwebservices.entity.User;
import com.rinseo.restfulwebservices.service.UserDAOService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    // Constructor-based dependency injection
    private UserDAOService dao;
    public UserController(UserDAOService dao) {
        this.dao = dao;
    }

    // Get all users
    // http://localhost:8082/users
    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return dao.getAll();
    }

    // Get a user by id
    // http://localhost:8082/users/1
    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable int id) {
        return dao.getById(id);
    }

    // Post a user
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        dao.save(user);
    }
}
