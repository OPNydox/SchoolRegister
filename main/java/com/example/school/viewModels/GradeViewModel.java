package com.example.school.viewModels;

public class GradeViewModel {
	
	private String mark;
	
	private String className;
	
	private String studentEmail;

	public GradeViewModel() { }
	
	public GradeViewModel(String mark, String className, String studentEmail) {
		super();
		this.setMark(mark);
		this.setClassName(className);
		this.setStudentEmail(studentEmail);
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	
}
