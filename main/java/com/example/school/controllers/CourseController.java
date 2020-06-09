package com.example.school.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
public class CourseController {
	
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/coursefind/{name}")
	public String courseTesting(@PathVariable String name) {
		Course  thisCourse = courseService.getCourseByName(name);
		
		System.out.println("Course found with name " + thisCourse.getCourseName() + " subject  " + thisCourse.getSubject());
		return "course find";
	}
	
	@PostMapping(value = "/coursecreate", consumes = "application/json", produces = "application/json")
	public void courseTesting1(@RequestBody CourseViewModel course) {
		courseService.addCourse(course);
		//return "course create";
	}
}
