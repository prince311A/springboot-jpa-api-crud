package com.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.models.UserLogin;
import com.security.models.UserPrinciple;
import com.security.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin user1 = repo.findByUsername(username);
		System.out.println(user1);
		if(user1==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new UserPrinciple(user1);
	}

}
