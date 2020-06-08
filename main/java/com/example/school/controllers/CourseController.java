package com.example.school.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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
public class CourseController {
	
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

	@RequestMapping(value = "techtest")
	public String teacherTesting() {
		TeacherViewModel teacher = new TeacherViewModel("Dimitar Dimitrov", "ddmitrov@abv.bg", "1234", "12.3");
		teacherService.addTeacher(teacher);
		Teacher teacherFound = null;
		try {
			teacherFound = teacherService.findTeacherByEmail("ddmitrov@abv.bg");
		} catch (ValueException e) {
			System.out.println(e.getMessage());
			return "teacher test";
		}
		
		if (teacherFound == null) {
			System.out.println("Teacher could not be found");
		}
		System.out.println("The teacher has been found");
		System.out.println("His name is " + teacherFound.getName());
		return "teacher test";
	}
	
	@RequestMapping("coursefind")
	public String courseTesting() {
		Course  thisCourse = courseService.getCourseByName("10A");
		
		System.out.println("Course found with name " + thisCourse.getCourseName() + " subject  " + thisCourse.getSubject());
		return "course find";
	}
	
	@RequestMapping("coursecreate")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void courseTesting1() {
		CourseViewModel newCourse = new CourseViewModel("10A", "Maths", "13");
		courseService.addCourse(newCourse);
		//return "course create";
	}
}
