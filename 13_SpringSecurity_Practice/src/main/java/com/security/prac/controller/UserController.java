package com.security.prac.controller;

import org.springframework.web.bind.annotation.RestController;

import com.security.prac.model.UserLogin2;
import com.security.prac.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/register")
	public UserLogin2 register(@RequestBody UserLogin2 userLogin2) {
		return service.registerUser(userLogin2);
	}

}
