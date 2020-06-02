package com.example.school.viewModels;

public class PresenceViewModel {
	
	private String presenceClass;
	
	private String studentEmail;

	public PresenceViewModel() { }

	public PresenceViewModel(String presenceClass, String studentEmail) {
		super();
		this.setPresenceClass(presenceClass);
		this.setStudentEmail(studentEmail);
	}

	public String getPresenceClass() {
		return presenceClass;
	}

	public void setPresenceClass(String presenceClass) {
		this.presenceClass = presenceClass;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
}
