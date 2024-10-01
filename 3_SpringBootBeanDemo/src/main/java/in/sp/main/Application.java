package in.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import in.sp.main.Entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(std1());
		System.out.println("------------------------");
		System.out.println(std2());
		
	}
	@Bean
	 Student std1() {
		return new Student("Prince Tiwari",101,95.5f);
	}
	@Bean
	 Student std2() {
		return new Student("Rahul Singh",102,55.5f);
	}
}
