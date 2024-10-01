package com.security.prac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.prac.model.UserLogin2;
import java.util.List;



	public interface UserRepo extends JpaRepository<UserLogin2, Integer> {
		public UserLogin2 findByUsername(String username);
	
}
