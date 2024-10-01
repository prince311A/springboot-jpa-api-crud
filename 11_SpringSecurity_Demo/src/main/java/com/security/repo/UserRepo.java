package com.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.models.UserLogin;

public interface UserRepo extends JpaRepository<UserLogin, Integer> {
	public UserLogin findByUsername(String username);
}
