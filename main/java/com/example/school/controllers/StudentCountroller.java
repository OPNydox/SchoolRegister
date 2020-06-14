package com.example.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.database.entities.Student;
import com.example.school.database.entities.User;
import com.example.school.repositories.UserRepository;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.utilities.ReturnResult;
import com.example.school.viewModels.StudentViewModel;

@RestController
public class StudentCountroller {
	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(value ="/studtest", consumes="application/json", produces="application/json")
	public ReturnResult studentTesting(@RequestBody StudentViewModel studentVM ) {
		ReturnResult result = new ReturnResult();
		StudentViewModel model = new StudentViewModel();
		Student student = studentService.createStudent(studentVM);
		
		if (student.isNull()) {
			result.setMessage("Could not create student with such parameters");
			result.setSuccesful(false);
			return result;
		}
		
		result.setSuccesful(true);
		result.setMessage("Student created");
		result.getData().add(student);
		
		return result;
		
	}
	
}
