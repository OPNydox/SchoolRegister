package com.example.school.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.school.database.entities.Student;
import com.example.school.exceptions.ValueException;
import com.example.school.repositories.StudentRepository;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.utilities.PasswordManager;
import com.example.school.utilities.Verificator;
import com.example.school.utilities.interfaces.IWriter;
import com.example.school.viewModels.StudentViewModel;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IWriter writer;

	@Override
	public Student createStudent(StudentViewModel student) {
		Student newStudent = new Student();
		
		try {
			Verificator.isEmpty(student.getEmail(), "Student email not found in model");
			Verificator.isEmpty(student.getName(), "Student name not found in model");
			Verificator.isEmpty(student.getPassword(), "Student password not found in model");
		} catch (ValueException e) {
			writer.writeError(e.getMessage());
			newStudent.setEmpty();
			return newStudent;
		}
		
		newStudent.setEmail(student.getEmail());
		newStudent.setName(student.getName());
		newStudent.setPassword(passwordEncoder.encode(student.getPassword()));
		
		newStudent = repository.save(newStudent);
		
		return newStudent;
	}

	@Override
	public Student findStudentByEmail(String email) {
		Student result = new Student();
		try {
			Verificator.isEmpty(email, "Email is empty");
			result = repository.findByEmail(email);
		} catch (ValueException e) {
			writer.writeError(e.getMessage());
			result.setEmpty();
		}
		return result;
	}

}
