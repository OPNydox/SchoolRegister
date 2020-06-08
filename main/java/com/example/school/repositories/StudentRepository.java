package com.example.school.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.school.database.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM students where email LIKE email")
	Student findByEmail(@Param("email")String email);

}
