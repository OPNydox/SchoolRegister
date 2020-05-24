package com.example.school.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "presences")
public class Presence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long presenceId;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Course presenceClass;

	public Presence() {
		super();
	}

	public Presence(Student student, Course presenceClass) {
		super();
		this.student = student;
		this.presenceClass = presenceClass;
	}
	
	public long getPresenceId() {
		return presenceId;
	}

	public void setPresenceId(long presenceId) {
		this.presenceId = presenceId;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getPresenceClass() {
		return presenceClass;
	}

	public void setPresenceClass(Course presenceClass) {
		this.presenceClass = presenceClass;
	}
	
	
}
