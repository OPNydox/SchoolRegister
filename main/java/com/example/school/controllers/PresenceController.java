package com.example.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.school.database.entities.Presence;
import com.example.school.services.interfaces.ICourseService;
import com.example.school.services.interfaces.IPresenceService;
import com.example.school.services.interfaces.IStudentService;
import com.example.school.viewModels.PresenceViewModel;

@Controller
public class PresenceController {
	
	@Autowired
	private IPresenceService presenceService;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping("/createpresence")
	public String createPresence() {
		PresenceViewModel presence = new PresenceViewModel();
		presence.setPresenceClass("10A");
		presence.setStudentEmail("iivanov@abv.bg");
		
		presenceService.addPresence(presence);
		return "Presence created";
	}
	
	@RequestMapping("/getpresencesstudent")
	public String getPresencesStudent() {
		List<Presence> presences = presenceService.getPresenceForStudentEmail("iivanov@abv.bg");
		
		for (Presence p : presences) {
			System.out.println("Student " + p.getStudent().getName() + " was in class " + p.getPresenceClass().getCourseName());
		}
		return "got presences";
	}
	
	@RequestMapping("/getpresencesclass")
	public String getPresencesClass() {
		List<Presence> presences = presenceService.getPresencesForClassName("10A");
		System.out.println("Class 10A was attended by:");
		
		for (Presence p : presences) {
			System.out.println(p.getStudent().getName());
		}
		
		return "class presences got";
	}

}
