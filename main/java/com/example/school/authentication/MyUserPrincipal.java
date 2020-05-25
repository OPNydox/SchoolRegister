package com.example.school.authentication;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.school.database.entities.Student;

public class MyUserPrincipal implements UserDetails {
	
	private Student user;
	
	public MyUserPrincipal(Student student) {
		super();
		this.user = student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collections.singleton(new SimpleGrantedAuthority("USER"));
		return null;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		String mail = this.user.getEmail();
		return mail;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
