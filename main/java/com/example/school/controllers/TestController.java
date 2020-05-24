package com.example.school.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.school.services.interfaces.IStudentService;
import com.example.school.servicesImplementations.CourseService;
import com.example.school.servicesImplementations.StudentService;
import com.example.school.viewModels.*;
@Controller
public class TestController {
	
	@Autowired
	private CourseService serv;
	
	@Autowired IStudentService stud;
	
	@RequestMapping(value ="/test")
	public Test testing() {
		serv.test();
		return new Test();
	}
	
	@RequestMapping(value ="/studtest")
	public Test studentTesting() {
		StudentView student = new StudentView("Ivan Ivanov", "parola1234");
		stud.createStudent(student);
		return new Test();
	}
}
