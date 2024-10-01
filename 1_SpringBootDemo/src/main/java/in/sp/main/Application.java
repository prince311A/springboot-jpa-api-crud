package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("This is Standalone Application");
		SpringApplication.run(Application.class, args);
		System.out.print("Hii Prince Tiwari");
		
	}

}
