package com.example.school.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.database.entities.Course;
import com.example.school.exceptions.ValueException;
import com.example.school.repositories.CourseRepository;
import com.example.school.services.interfaces.ICourseService;
import com.example.school.utilities.Verificator;
import com.example.school.viewModels.CourseViewModel;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository repository;

	@Override
	public Course addCourse(CourseViewModel course) {
		Course newCourse;
		String name;
		String subject;
		int honorarium;
		try {
			Verificator.isEmpty(name = course.getName(), "No name found in course"); 
			Verificator.isEmpty(subject = course.getSubject(), "No subject found in course");
			Verificator.isEmpty(honorarium = Integer.parseInt(course.getHonorarium()), "Nohonorarium found in course");
		} catch (ValueException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (NumberFormatException e) {
			System.out.println("Honorarium should be an integer number");
			return null;
		}
		
		newCourse = new Course(name, subject, honorarium);
		
		newCourse = repository.save(newCourse);
		return newCourse;
	}

}
