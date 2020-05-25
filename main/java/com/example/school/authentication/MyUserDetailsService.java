package com.example.school.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.school.database.entities.Student;
import com.example.school.repositories.StudentRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private final StudentRepository userRepository;
	
	public MyUserDetailsService(StudentRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = new Student();
		if (null == student) {
			throw new UsernameNotFoundException("User with this email was not found: " + student.getEmail());
		}
		return new MyUserPrincipal(student);
	}

}
