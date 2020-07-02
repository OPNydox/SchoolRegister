package com.example.school.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.school.database.entities.Course;
import com.example.school.exceptions.ValueException;
import com.example.school.repositories.CourseRepository;
import com.example.school.services.interfaces.ICourseService;
import com.example.school.utilities.Verificator;
import com.example.school.utilities.interfaces.IWriter;
import com.example.school.viewModels.CourseViewModel;
import com.example.school.viewModels.decorators.CourseVMValidator;
import com.example.school.viewModels.decorators.ModelDecorator;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private IWriter writer;

	@Override
	@Transactional
	public Course addCourse(CourseViewModel course) {
		Course newCourse =  new Course();
		List<String> validationErrors = new ArrayList<>();
		
		ModelDecorator decorator = new ModelDecorator(course);
		
		validationErrors.addAll(decorator.validateModel(new CourseVMValidator()));
		
		if (!validationErrors.isEmpty()) {
			newCourse.setEmpty();
			writer.writeErrors(validationErrors);
			return newCourse;
		}
		
		newCourse = new Course(course.getSubject(), course.getName(), Integer.parseInt(course.getHonorarium()));
		
		newCourse = repository.save(newCourse);
		return newCourse;
	}

	@Override
	public Course getCourseByName(String courseName) {
		Course result = new Course();
		CourseViewModel foundCourse = new CourseViewModel();
		try {
			Verificator.isEmpty(courseName, "Course name is empty");
			result = repository.findByName(courseName);
		} catch (Exception e) {
			writer.writeError(e.getMessage());
			result.setEmpty();
		}
		return result;
	}

	@Override
	public void saveCourse(Course course) {
		repository.save(course);
		
	}

}
