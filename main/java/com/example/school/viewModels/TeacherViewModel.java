package com.example.school.viewModels;

public class TeacherViewModel {
	private String name;
	
	private String email;
	
	private String password;
	
	private String salary;
	
	public TeacherViewModel() { }
	
	public TeacherViewModel(String name, String email, String password, String salary) {
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
		this.setSalary(salary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
