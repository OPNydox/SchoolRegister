package com.example.school.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.school.database.entities.AuthGroup;
import com.example.school.database.entities.Student;
import com.example.school.database.entities.User;
import com.example.school.repositories.AuthGroupRepository;
import com.example.school.repositories.StudentRepository;
import com.example.school.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	
	private final AuthGroupRepository authGroupRepository;
	
	public MyUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
		super();
		this.userRepository = userRepository;
		this.authGroupRepository = authGroupRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User();
		if (null == user) {
			throw new UsernameNotFoundException("User with this email was not found: " + user.getEmail());
		}
		List<AuthGroup> authGroups = this.authGroupRepository.findByEmail(username);
		return new MyUserPrincipal(user, authGroups);
	}

}
