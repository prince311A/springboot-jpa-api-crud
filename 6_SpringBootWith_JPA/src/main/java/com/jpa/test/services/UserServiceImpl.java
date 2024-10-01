package com.jpa.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.entity.User;
import com.jpa.test.repository.UserRepostitory;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepostitory userRepostitory;

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			userRepostitory.save(user);
			status = true;
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List<User> getAllUser() {
		return userRepostitory.findAll();
	}

	@Override
	public User getUserById(int id) {
		Optional<User> user = userRepostitory.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public boolean updateUserDetails(int id, String city) {
		boolean status = false;
		User user = getUserById(id);
		if(user!=null) {
			user.setCity(city);
			userRepostitory.save(user);
			status = true;
		}
		return status;
	}

	@Override
	public boolean delelteUser(int id) {
		User user = getUserById(id);
	
		boolean status = false;
		try {
			userRepostitory.delete(user);
			status = true;
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<User> findUSersByCity(String city) {
		return userRepostitory.findByCity(city);
	}
	
}
