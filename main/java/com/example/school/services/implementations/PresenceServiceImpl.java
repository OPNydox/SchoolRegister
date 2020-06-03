package com.example.school.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.school.database.entities.Course;
import com.example.school.database.entities.Presence;
import com.example.school.database.entities.Student;
import com.example.school.exceptions.ValueException;
import com.example.school.repositories.PresenceRepository;
import com.example.school.services.interfaces.ICourseService;
import com.example.school.services.interfaces.IPresenceService;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.utilities.Verificator;
import com.example.school.utilities.interfaces.IWriter;
import com.example.school.viewModels.PresenceViewModel;

public class PresenceServiceImpl implements IPresenceService{

	@Autowired
	private PresenceRepository presenceRepository;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private IWriter writer;

	@Override
	public Presence addPresence(PresenceViewModel presenceModel) {
		Presence newPresence = new Presence();
		Course presenceCourse;
		Student studentPresence;
		
		try {
			Verificator.isEmpty(presenceModel, "The presence model does not exist");
			Verificator.isEmpty(presenceModel.getPresenceClass(), "No class found in model");
			Verificator.isEmpty(presenceModel.getStudentEmail(), "Student email in model is empty");
			presenceCourse = courseService.getCourseByName(presenceModel.getPresenceClass());
			studentPresence = studentService.findStudentByEmail(presenceModel.getStudentEmail());
			Verificator.isEmpty(presenceCourse, "No course found with the name " + presenceModel.getPresenceClass());
			Verificator.isEmpty(studentPresence, "No Student found with the email");
		} catch (ValueException e) {
			writer.writeError(e.getMessage());
			return null;
		}
		
		newPresence.setPresenceClass(presenceCourse);
		newPresence.setStudent(studentPresence);
		presenceRepository.save(newPresence);
		
		return newPresence;
	}

	@Override
	public List<Presence> getPresencesForClassName(String className) {
		Course resultCourse;
		List<Presence> result = new ArrayList<Presence>();
		
		try {
			Verificator.isEmpty(className, "Class name is empty");
			resultCourse = courseService.getCourseByName(className);
			Verificator.isEmpty(resultCourse, "Could not find a course with the name " + className);
		} catch (ValueException e) {
			writer.writeError(e.getMessage());
			return null;
		}
		
		result = getPresencesForClass(resultCourse);
		
		return result;
	}

	@Override
	public List<Presence> getPresencesForClass(Course course) {
		List<Presence> presences = new ArrayList<Presence>();
		List<Student> studentsInCourse = new ArrayList<Student>();
		
		try {
			Verificator.isEmpty(course, "Course object is empty");
		} catch (ValueException e) {
			writer.writeError(e.getMessage());
		}
		
		studentsInCourse = course.getStudents();
		studentsInCourse.forEach((student) -> presences.addAll(student.getPresences()));
		return presences;
	}

	@Override
	public List<Presence> getPresenceForStudentEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Presence> getPresenceForStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
