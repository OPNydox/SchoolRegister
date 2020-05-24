package com.example.school.database.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacherId;
	
	private String name;
	
	private String email;
	
	@Column(length = 60)
	private String password;
	
	private double salary;
	
	@ManyToMany
	@JoinTable(name="teacher_course",
			joinColumns = @JoinColumn(name = "teacher_id"),
			inverseJoinColumns=@JoinColumn(name = "course_id"))
	private List<Course> courses;

	

	public Teacher(String name, String email, String password, double salary) {
		super();
		setName(name);
		setEmail(email);
		setPassword(password);
		setSalary(salary);
		setCourses(new ArrayList<Course>());
	}

	public Teacher() {
		super();
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
