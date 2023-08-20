package com.rinseo.restfulwebservices.jpa;


import com.rinseo.restfulwebservices.entity.User;
import com.rinseo.restfulwebservices.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


/**
 * A controller that uses JPA interface to access the database.
 */
@RestController
public class UserJPA {
    private UserRepository repo;

    public UserJPA(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: ".concat(String.valueOf(id)));
        }
        return user;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = repo.save(user);
        // /users/3 => /users/{id} => savedUser.getId()
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Endpoints for posts, user has many posts
}
