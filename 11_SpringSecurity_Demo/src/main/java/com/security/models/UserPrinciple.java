package com.security.models;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrinciple implements UserDetails {
	private UserLogin userLogin;

	public UserPrinciple(UserLogin user1) {
		// TODO Auto-generated constructor stub
		this.userLogin = user1;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority("ROLES"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userLogin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userLogin.getUsername();
	}

}
