package com.example.school.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.school.database.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long>{
	 

}
