package com.example.school.viewModels.decorators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.school.viewModels.GradeViewModel;
import com.example.school.viewModels.ViewModel;
import com.example.school.viewModels.decorators.dataValidators.EmailValidator;
import com.example.school.viewModels.decorators.dataValidators.StringNumberValidator;
import com.example.school.viewModels.decorators.dataValidators.StringValidator;

public class GradeVMValidator implements VMValidator{

	private GradeViewModel grade;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private StringValidator stringValidator;
	
	@Autowired
	private StringNumberValidator numberValidator;
	
	@Override
	public List<String> validate() {
		List<String> result = new ArrayList<>();
		
		if (grade == null) {
			result.add("Grade validator not initialised.");
			return result;
		}
		
		result.addAll(stringValidator.validateString(grade.getClassName(), "Course name", 50));
		result.addAll(emailValidator.validateEmail(grade.getStudentEmail()));
		result.addAll(numberValidator.validateNumber(grade.getMark()));
		
		return result;
	}

	@Override
	public boolean injectModel(ViewModel model) {
		// TODO Auto-generated method stub
		return false;
	}

}
