package com.security.prac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.prac.model.UserLogin2;
import com.security.prac.repo.UserRepo;
@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	// this to encrypt the password
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();}
	// OR
//	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
	
	public UserLogin2 registerUser(UserLogin2 userLogin2) {
		// Encrypting the password before save
	userLogin2.setPassword(passwordEncoder().encode(userLogin2.getPassword())); // for shivam password is shivam@1234
	return	repo.save(userLogin2);
	
	}
}
