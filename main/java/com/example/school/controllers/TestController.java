package com.example.school.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.school.database.entities.Course;
import com.example.school.database.entities.Student;
import com.example.school.database.entities.Teacher;
import com.example.school.database.entities.User;
import com.example.school.exceptions.ValueException;
import com.example.school.repositories.StudentRepository;
import com.example.school.repositories.UserRepository;
import com.example.school.services.interfaces.ICourseService;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.services.interfaces.ITeacherService;
import com.example.school.viewModels.*;
@Controller
public class TestController {
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private UserRepository<User> uRepo;
	
	@Autowired IStudentService stud;
	
	@Autowired ITeacherService teacherService;
	
	
	@RequestMapping(value ="/test")
	public Test testing() {
		//serv.test();
		return new Test();
	}
	
	@RequestMapping(value ="/studtest")
	public Test studentTesting() {
		Student student = new Student("Ivan Ivanov", "iivanov@abv.bg", "password");
		uRepo.save(student);
		User u = uRepo.findByEmail("iivanov@abv.bg");
		System.out.println("The user is called " + u.getName());
		return new Test();
	}
	
	@RequestMapping(value = "techtest")
	public Test teacherTesting() {
		TeacherViewModel teacher = new TeacherViewModel("Dimitar Dimitrov", "ddmitrov@abv.bg", "1234", "12.3");
		teacherService.addTeacher(teacher);
		Teacher teacherFound = null;
		try {
			teacherFound = teacherService.findTeacherByEmail("ddmitrov@abv.bg");
		} catch (ValueException e) {
			System.out.println(e.getMessage());
			return new Test();
		}
		
		if (teacherFound == null) {
			System.out.println("Teacher could not be found");
		}
		System.out.println("The teacher has been found");
		System.out.println("His name is " + teacherFound.getName());
		return new Test();
	}
	
	@RequestMapping("coursefind")
	public String courseTesting() {
		Course  thisCourse = courseService.getCourseByName("10A");
		
		return("Course found with name " + thisCourse.getCourseName() + " subject  " + thisCourse.getSubject());
		//return new Test();
	}
	
	@RequestMapping("coursecreate")
	public Test courseTesting1() {
		CourseViewModel newCourse = new CourseViewModel("10A", "Maths", "13");
		courseService.addCourse(newCourse);
		return new Test();
	}
}
