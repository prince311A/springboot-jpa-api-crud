package com.security.prac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.prac.model.UserLogin2;
import com.security.prac.model.UserPrinciple;
import com.security.prac.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("Username is"+username);
		UserLogin2 user1 = repo.findByUsername(username);
//		System.out.println("Sorry "+user1);
		if(user1==null) {
			throw new UsernameNotFoundException("User Not Found");
		
		}
		UserPrinciple userPrinciple = new UserPrinciple(user1);
//		System.out.println("this"+userPrinciple.getUsername()); //testing
//		System.out.println("this"+userPrinciple.getPassword()); // testing
		return userPrinciple;
	
	}
 
}
