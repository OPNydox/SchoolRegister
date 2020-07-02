package com.example.school.viewModels.decorators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.school.viewModels.CourseViewModel;
import com.example.school.viewModels.ViewModel;
import com.example.school.viewModels.decorators.dataValidators.StringNumberValidator;
import com.example.school.viewModels.decorators.dataValidators.StringValidator;

public class CourseVMValidator implements VMValidator{

	private CourseViewModel course;
	
	@Autowired
	private StringValidator stringValidator;
	
	@Autowired
	private StringNumberValidator numberValidator;
	
	@Override
	public List<String> validate() {
		List<String> result = new ArrayList<>();
		
		result.addAll(stringValidator.validateString(course.getName(), "Course name", 30));
		result.addAll(stringValidator.validateString(course.getSubject(), "Course subject", 50));
		result.addAll(numberValidator.validateNumber(course.getHonorarium()));
		
		return result;
	}

	@Override
	public boolean injectModel(ViewModel model) {
		if (model == null) {
			return false;
		}
		
		course = (CourseViewModel) model;
		return true;
	}

}
