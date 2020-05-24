package com.example.school.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.repositories.CourseRepository;
import com.example.school.services.interfaces.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository repository;

}
