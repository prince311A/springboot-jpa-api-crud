package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.models.User;
import com.security.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;

	// all users
	@GetMapping("/")
	// if we don't want to configure in SecurityFilterChain than
//		@PreAuthorize("hasRole('ADMIN')") // to enable the annotation we use annotation in MySecurityConfig class with @EnableGlobalMethodSecurity
	public List<User> getAllUsers() {
		return service.getAllUser();

	}

	// return single user
	@GetMapping("/{username}")
	// if we don't want to configure in SecurityFilterChain than
//		@PreAuthorize("hasRole('ADMIN')")
	public User getSingleUser(@PathVariable("username") String username) {
		return service.getUserById(username);
	}

	// add user
	@PostMapping("/")
	// if we don't want to configure in SecurityFilterChain than
//	@PreAuthorize("hasRole('ADMIN')")
	public User addUsers(@RequestBody User user) {
		return service.addUser(user);

	}

	// for admin only
	// all users
	@GetMapping("/public")
	// if we don't want to configure in SecurityFilterChain than

	public ResponseEntity<String> forPublic() {
		return ResponseEntity.ok("Hii... This is for all admin and normal user");
	}

	@GetMapping("/normal")
	// if we don't want to configure in SecurityFilterChain than
//		@PreAuthorize("hasRole('NORMAL')")
	public ResponseEntity<String> forNormal() {
		return ResponseEntity.ok("Hii... This is for normal user");
	}

}
