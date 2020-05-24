package com.example.school.database.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long classId;
	
	private String subject;
	
	private int honorarium;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;
	
	@ManyToMany(mappedBy = "courses")
	private List<Teacher> teachers;
	
	@OneToMany(mappedBy = "classGrade")
	private List<Grade> grades;

	public Course() {
		super();
	}

	public Course(String subject, int honorarium) {
		super();
		setSubject(subject);
		setHonorarium(honorarium);
		setStudents(new ArrayList<Student>());
		setTeachers(new ArrayList<Teacher>());
		setGrades(new ArrayList<Grade>());
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getHonorarium() {
		return honorarium;
	}

	public void setHonorarium(int honorarium) {
		this.honorarium = honorarium;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	} 
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}
}