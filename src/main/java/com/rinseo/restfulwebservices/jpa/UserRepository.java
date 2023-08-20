package com.rinseo.restfulwebservices.jpa;

import com.rinseo.restfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
