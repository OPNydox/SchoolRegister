package com.example.school.servicesImplementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.school.services.interfaces.IStudentService;
import com.example.school.viewModels.StudentView;
import com.example.school.utilities.*;

public class StudentService implements IStudentService {
	@Autowired
	public PasswordManager passwordEncoder;
	
	@Override
	public void createStudent(StudentView student) {
		System.out.println("The student is called "+ student.getName());
		
		
	}
	
}
