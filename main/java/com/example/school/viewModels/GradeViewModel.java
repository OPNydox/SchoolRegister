package com.example.school.viewModels;

public class GradeViewModel {
	
	private String mark;
	
	private String className;

	public GradeViewModel() { }
	
	public GradeViewModel(String mark, String className) {
		super();
		this.mark = mark;
		this.className = className;
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
}
