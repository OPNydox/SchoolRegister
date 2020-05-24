package com.example.school.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.school.database.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	Course save(Course entity);
}
