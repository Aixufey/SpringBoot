package com.rinseo.jpahibernate;

import com.rinseo.jpahibernate.jpa.Course;
import com.rinseo.jpahibernate.springDataJpa.CourseSpringDataJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner is a Functional Interface from Spring Boot
 * Run method is called when the application starts
 */
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    This is for classic JDBC
//    @Autowired
//    private CourseJDBCRepository repo;

//    This is for JPA
//    @Autowired
//    private CourseJPARepository repo;

//    This is for Spring Data JPA
    @Autowired
    private CourseSpringDataJPARepository repo;

    @Override
    public void run(String... args) throws Exception {
//        repo.insert(new Course(1, "Learn AWS now", "Rinseo"));
//        repo.insert(new Course(2, "Learn Spring now", "Rinseo"));
//        repo.insert(new Course(3, "Learn Java now", "Rinseo"));
//        repo.getAll().forEach(System.out::println);

        repo.save(new Course(1, "Learn AWS now", "Rinseo"));
        repo.save(new Course(2, "Learn Spring now", "Rinseo"));
        repo.save(new Course(3, "Learn Java now", "Rinseo"));

        repo.deleteById(2L);

        repo.findAll().forEach(System.out::println);

        repo.findByAuthor("Rinseoz").stream().findFirst().ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No author found")
        );

        repo.findByName("Learn Java now").stream().findAny().ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No name found")
        );
    }

}
