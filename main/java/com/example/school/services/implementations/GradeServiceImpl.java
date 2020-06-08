package com.example.school.services.implementations;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.database.entities.Grade;
import com.example.school.database.entities.Student;
import com.example.school.exceptions.ValueException;
import com.example.school.repositories.CourseRepository;
import com.example.school.repositories.GradeRepository;
import com.example.school.services.interfaces.IGradeService;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.utilities.Verificator;
import com.example.school.utilities.interfaces.IWriter;
import com.example.school.viewModels.GradeViewModel;

@Service
public class GradeServiceImpl  implements IGradeService {
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IWriter writer;

	@Override
	public Grade addGrade(GradeViewModel gradeModel) {
		Grade newGrade = new Grade();
		Student gradeStudent= new Student();
		
		try {
			Verificator.isEmpty(gradeModel.getClassName(), "Class name in model is empty");
			Verificator.isEmpty(gradeModel.getMark(), "Mark in model is empty");
			Verificator.isEmpty(gradeModel.getStudentEmail(), "Student email in model is empty");
			newGrade.setMark(Double.parseDouble(gradeModel.getMark()));
			newGrade.setClassGrade(courseRepository.findByName(gradeModel.getClassName()));
			gradeStudent = studentService.findStudentByEmail(gradeModel.getStudentEmail());
			Verificator.isEmpty(gradeStudent, "Can't find that student in database");
			newGrade.setStudent(gradeStudent);
			gradeStudent.getGrades().add(newGrade);
			gradeRepository.save(newGrade);
		} catch ( ValueException e) {
			writer.writeError(e.getMessage());
		}
		return newGrade;
	}

}
