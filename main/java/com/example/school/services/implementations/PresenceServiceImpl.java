package com.example.school.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.school.database.entities.Course;
import com.example.school.database.entities.Presence;
import com.example.school.database.entities.Student;
import com.example.school.exceptions.ValueException;
import com.example.school.repositories.PresenceRepository;
import com.example.school.services.interfaces.ICourseService;
import com.example.school.services.interfaces.IPresenceService;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.servicesImplementations.StudentService;
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
		
		
		
		return null;
	}
	
}
