package com.rinseo.restfulwebservices.service;


import com.rinseo.restfulwebservices.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Spring Boot will manage this bean because of @Component annotation.
 * We can inject this bean in controller to utilize the methods.
 * Storing users in a database then using JPA / Hibernate to access the database.
 */
@Component
public class UserDAOService {

    // Dummy static data
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static {
        users.add(new User(++usersCount, "Dummy 1", LocalDate.now().minusYears(10)));
        users.add(new User(++usersCount, "Dummy 2", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Dummy 3", LocalDate.now().minusYears(30)));
    }

    public List<User> getAll() {
        return users;
    }

    public User getById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = u -> u.getId().equals(id);
        users.removeIf(predicate);
    }
}
