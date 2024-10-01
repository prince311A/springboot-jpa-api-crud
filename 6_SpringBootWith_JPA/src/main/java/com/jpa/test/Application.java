package com.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.jpa.test.entity.User;
import com.jpa.test.repository.UserRepostitory;
import com.jpa.test.services.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);
		UserService service = context.getBean(UserService.class);

		User user = new User();
		user.setName("Rahul Rai");
		user.setCity("Mumbai");
		user.setPhone("7410258963");

		// insertion
//		boolean status = service.registerUser(user);
//		if(status){
//		System.out.println("Successfull Registered");
//		}else {
//			System.out.println("Something went wrong");
//		}
		
		// Fetching all rows
//		List<User>users = service.getAllUser();
//		for(User i:users) {
//			System.out.println(i);
//		}
		
//		// Fetch by ID
//		User user2 = service.getUserById(2);
//		System.out.println(user);
		
//		// Update Details
//	boolean status = service.updateUserDetails(2, "satna");
//	System.out.println(status);
		
//		// Deletion
//		boolean status2 = service.delelteUser(2);
//		System.out.println(status2);
		
		// Custom Finder
		List<User>users1 = service.findUSersByCity("Delhi");
		for(User u: users1) {
			System.out.println(u);
		}
	}

}
