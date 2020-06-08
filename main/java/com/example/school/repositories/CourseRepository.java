package com.example.school.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.school.database.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	Course save(Course entity);
	
	@Query(nativeQuery = true, value = "SELECT * FROM classes where course_name LIKE course_name")
	Course findByName(@Param("course_name")String course_name);
}
