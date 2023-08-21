package com.rinseo.restfulwebservices.jpa;

import com.rinseo.restfulwebservices.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
