package com.rinseo.jpahibernate.springDataJpa;

import com.rinseo.jpahibernate.jpa.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA class Repository pattern needs to implement JpaRepository
 * Course is already mapped to the database table
 * Long is the type of the primary key
 */
public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
