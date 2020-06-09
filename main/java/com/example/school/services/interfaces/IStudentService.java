package com.example.school.services.interfaces;

import com.example.school.database.entities.Student;
import com.example.school.viewModels.StudentViewModel;

public interface IStudentService {
	Student createStudent(StudentViewModel student);
	
	Student findStudentByEmail(String email);
}
