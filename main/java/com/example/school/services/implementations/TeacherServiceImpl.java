package com.example.school.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.database.entities.Course;
import com.example.school.database.entities.Teacher;
import com.example.school.exceptions.EmailNotValidExcepiton;
import com.example.school.exceptions.ValueException;
import com.example.school.exceptions.ValueNotFoundException;
import com.example.school.repositories.CourseRepository;
import com.example.school.repositories.TeacherRepository;
import com.example.school.services.interfaces.ITeacherService;
import com.example.school.utilities.Verificator;
import com.example.school.viewModels.TeacherViewModel;

@Service
public class TeacherServiceImpl implements ITeacherService {
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Teacher addTeacher(TeacherViewModel teacherView) {
		Teacher newTeacher = new Teacher();
		newTeacher.setName(teacherView.getName());
		newTeacher.setEmail(teacherView.getEmail());
		newTeacher.setPassword(teacherView.getPassword());
		newTeacher.setSalary(Double.parseDouble(teacherView.getSalary()));
		
		Teacher result = teacherRepository.save(newTeacher);
		return result;
	}

	@Override
	public Teacher findTeacherByEmail(String email) throws ValueException {
		if (email == null) {
			throw new ValueNotFoundException("Teacher search email is empty");
		}
		
		boolean isEmailValid = Verificator.verifyEmail(email);
		
		if (isEmailValid) {
			throw new EmailNotValidExcepiton("The email: " + email + " is not a valid email");
		}
		
		Teacher result = teacherRepository.findByEmail(email);
		return result;
	}

	@Override
	public boolean addTeacherToCourse(Teacher teacher, Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTeacherToCourse(String teacherEmail, String courseName) {
		// TODO Auto-generated method stub
		return false;
	}

}
