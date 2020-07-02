package com.example.school.viewModels.decorators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.school.viewModels.TeacherViewModel;
import com.example.school.viewModels.ViewModel;
import com.example.school.viewModels.decorators.dataValidators.EmailValidator;
import com.example.school.viewModels.decorators.dataValidators.StringNumberValidator;
import com.example.school.viewModels.decorators.dataValidators.StringValidator;

public class TeacherVMValidator implements VMValidator {
	private TeacherViewModel teacher;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private StringValidator stringValidator;
	
	@Autowired
	private StringNumberValidator numberValidator;

	@Override
	public List<String> validate() {
		List<String> result = new ArrayList<String>();
		
		if (teacher == null) {
			result.add("Teacher validator not initialized");
			return result;
		}
		
		result.addAll(emailValidator.validateEmail(teacher.getEmail()));
		result.addAll(stringValidator.validateString(teacher.getName(), "Teacher name", 50));
		result.addAll(stringValidator.validateString(teacher.getPassword(), "Teacher password", null));
		result.addAll(numberValidator.validateNumber(teacher.getSalary()));
		return null;
	}

	@Override
	public boolean injectModel(ViewModel model) {
		if (model == null) {
			return false;
		}
		this.teacher = (TeacherViewModel) model;
		
		return true;
	}

}
