package in.sp.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("This is Home Page");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("This is Contact Page");
		return "contact";
	}
}
