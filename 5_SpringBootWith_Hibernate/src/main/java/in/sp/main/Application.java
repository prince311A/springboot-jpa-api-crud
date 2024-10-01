package in.sp.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entity.User;
import in.sp.main.repository.DB_Operations;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ApplicationContext context	= SpringApplication.run(Application.class, args);
		DB_Operations db_Operations = context .getBean(DB_Operations.class);
		
		User user = new User();
		user.setName("Aman Tiwari");
		user.setEmail("aman@gmail.com");
		user.setPassword("aman123");
		user.setPhone("1245789630");
		
//		int i = db_Operations.registerUser(user);
//		System.out.println(i);
		User user2 = db_Operations.getUserDetails(2);
		System.out.println(user);
		
		
		
		
		
	}

}
