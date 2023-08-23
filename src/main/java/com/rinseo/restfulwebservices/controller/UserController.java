package com.rinseo.restfulwebservices.controller;


import com.rinseo.restfulwebservices.entity.User;
import com.rinseo.restfulwebservices.exceptions.UserNotFoundException;
import com.rinseo.restfulwebservices.service.UserDAOService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = dao.getById(id);
        if (user == null) {
            throw new UserNotFoundException("id: ".concat(String.valueOf(id)));
        }
        return user;
    }

    /**
     * Post a user
     * http://localhost:8082/users and payload in body
     * @param user
     * @return 201 with a location-header URI e.g. http://localhost:8082/users/3
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = dao.save(user);
        // /users/3 => /users/{id} => savedUser.getId()
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Delete a user by id
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        dao.deleteById(id);
    }
}
