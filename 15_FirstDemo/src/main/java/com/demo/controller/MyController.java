package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class MyController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to First-Demo";
	}
	
	@PostMapping("/add")
	public int add(@RequestParam("num1")int x,@RequestParam("num2")int y) {
		System.out.println("Number1 : "+x);
		System.out.println("Number2 : "+y);
		int sum = x+y;
		System.out.println("Sum : "+sum);
		return sum;
	}
	
}
