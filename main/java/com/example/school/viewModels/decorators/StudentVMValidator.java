package com.example.school.viewModels.decorators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.school.viewModels.StudentViewModel;
import com.example.school.viewModels.ViewModel;
import com.example.school.viewModels.decorators.dataValidators.EmailValidator;
import com.example.school.viewModels.decorators.dataValidators.StringValidator;

public class StudentVMValidator implements VMValidator {
	
	private StudentViewModel student;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private StringValidator stringValidator;

	@Override
	public List<String> validate() {
		List<String> result = new ArrayList<String>();
		
		if (student == null) {
			result.add("Student validator not initialized");
			return result;
		}
		
		result.addAll(emailValidator.validateEmail(student.getEmail()));
		result.addAll(stringValidator.validateString(student.getName(), "The student's name", 50));
		result.addAll(stringValidator.validateString(student.getPassword(), "Student's passowrd", null));
		return null;
	}

	@Override
	public boolean injectModel(ViewModel model) {
		if (model == null || model.isEmpty()) {
			return false;
		}
		
		student = (StudentViewModel) model;
		
		return true;
	}

}
