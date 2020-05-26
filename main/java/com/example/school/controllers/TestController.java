package com.example.school.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.school.database.entities.Student;
import com.example.school.database.entities.User;
import com.example.school.repositories.StudentRepository;
import com.example.school.repositories.UserRepository;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.servicesImplementations.CourseService;
import com.example.school.servicesImplementations.StudentService;
import com.example.school.viewModels.*;
@Controller
public class TestController {
	
	@Autowired
	private CourseService serv;
	
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private UserRepository<User> uRepo;
	
	@Autowired IStudentService stud;
	
	@RequestMapping(value ="/test")
	public Test testing() {
		serv.test();
		return new Test();
	}
	
	@RequestMapping(value ="/studtest")
	public Test studentTesting() {
		User u = uRepo.findByEmail("iivanov@abv.bg");
		System.out.println("The user is called " + u.getName());
		return new Test();
	}
}
