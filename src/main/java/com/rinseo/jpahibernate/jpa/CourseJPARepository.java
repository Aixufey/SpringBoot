package com.rinseo.jpahibernate.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseJPARepository {
    // Autowire or PersistenceContext both work.
    // This is managing the entity.
    @PersistenceContext
    private EntityManager entityManager;


    // Course Bean is mapped using merge.
    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    public List<Course> getAll() {
        TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course", Course.class);
        return query.getResultList();
    }

}
