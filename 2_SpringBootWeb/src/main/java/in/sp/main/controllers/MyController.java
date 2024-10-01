package in.sp.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/")
	@ResponseBody
	public String welcome() {
		return"Hii I am Prince Tiwari";
	}
}
