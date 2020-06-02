package com.example.school.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.school.database.entities.Student;
import com.example.school.repositories.StudentRepository;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.utilities.PasswordManager;
import com.example.school.viewModels.StudentViewModel;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;

	@Override
	public void createStudent(StudentViewModel student) {
		System.out.println("hello from the backend");
		System.out.println("The student has a name " + student.getName());
		System.out.println("The student has a before password " + student.getPassword());
		System.out.println("Stored password  " + passwordEncoder.encode(student.getPassword()));
		
	}

	@Override
	public Student findStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
