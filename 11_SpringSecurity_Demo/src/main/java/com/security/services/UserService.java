package com.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.models.User;

@Service
public class UserService {
	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("Prince Tiwari","prince1234","prince@gmail.com"));
		list.add(new User("Vandana Sahu","vandu@112","vandu@gmail.com"));
		list.add(new User("Risha Gupta","risha77P","risha@gmail.com"));
	}
	// get all users
	public List<User> getAllUser(){
		return list;
	}
	// get single user
	public User getUserById(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
		
	}
	// add user
	public User addUser(User user) {
		list.add(user);
		return user;
	}
	

}
