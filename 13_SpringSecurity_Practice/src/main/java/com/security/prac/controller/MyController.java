package com.security.prac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.prac.repo.UserRepo;

@RestController
@RequestMapping("/security")
public class MyController {
	@GetMapping("/all")
	public String forAllUser() {
		return "This is a Public Page Both For Users and Admin";
		
	}

}
