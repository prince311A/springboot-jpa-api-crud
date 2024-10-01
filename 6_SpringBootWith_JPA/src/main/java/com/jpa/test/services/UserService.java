package com.jpa.test.services;

import java.util.List;

import com.jpa.test.entity.User;

public interface UserService {
	public boolean registerUser(User user);
	public List<User> getAllUser();
	public User getUserById(int id);
	public boolean updateUserDetails(int id,String city);// where to update, what to update
	public boolean delelteUser(int id);
	// example of custom introducer
	public List<User>findUSersByCity(String city);

}
