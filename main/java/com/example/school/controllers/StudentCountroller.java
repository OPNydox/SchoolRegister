package com.example.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.school.database.entities.Student;
import com.example.school.database.entities.User;
import com.example.school.repositories.UserRepository;

@Controller
public class StudentCountroller {
	
	@Autowired
	private UserRepository<User> uRepo;
	
	@RequestMapping(value ="/studtest")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void studentTesting() {
		Student student = new Student("Ivan Ivanov", "iivanov@abv.bg", "password");
		uRepo.save(student);
		//return "The user is called Ivan Ivanov";
	}
	
}
