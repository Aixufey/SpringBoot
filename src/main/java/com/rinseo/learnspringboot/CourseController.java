package com.rinseo.learnspringboot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Pattern: Rest Controller is handling HTTP requests and acting as a bridge between HTTP requests and business service.
 * HTTP means URL, HTTP method, and HTTP response status code.
 *
 */
@RestController
public class CourseController {

    /**
     * Mapping the endpoint to this method.
     * @return A list of courses
     */
    @RequestMapping("/courses")
    public List<Course> getAll() {
        return Arrays.asList(
                new Course(1, "Learn Spring Boot", "Sparrow"),
                new Course(2, "Learn Spring MVC", "Sparrow"),
                new Course(3, "Learn Struts", "Sparrow"),
                new Course(4, "Learn Hibernate", "Sparrow"),
                new Course(5, "Learn JPA", "Sparrow"),
                new Course(6, "Learn Spring Data JPA", "Sparrow"),
                new Course(7, "Learn Spring Security", "Sparrow")
        );
    }
}
