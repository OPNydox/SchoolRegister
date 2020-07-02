package com.example.school.services.implementations;

import java.util.ArrayList;
import java.util.List;

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
import com.example.school.viewModels.decorators.ModelDecorator;
import com.example.school.viewModels.decorators.StudentVMValidator;

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
		List<String> validationResult = new ArrayList<>();
		
		ModelDecorator decorator = new ModelDecorator(student); 
		
		validationResult.addAll(decorator.validateModel(new StudentVMValidator()));
		
		if (!validationResult.isEmpty()) {
			newStudent.setEmpty();
			writer.writeErrors(validationResult);
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
	
	@Override
	public List<Student> findAllStudents() {
		List<Student> result;
		
		result = (List<Student>) repository.findAll();
		return result;
	}


}
