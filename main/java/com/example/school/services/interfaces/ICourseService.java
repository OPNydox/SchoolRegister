package com.example.school.services.interfaces;

import com.example.school.database.entities.Course;
import com.example.school.viewModels.CourseViewModel;

public interface ICourseService {
	
	Course addCourse(CourseViewModel course);
}
