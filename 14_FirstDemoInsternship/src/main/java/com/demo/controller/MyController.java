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
	public String welcomePage() {
		return "Welcome To First RESTAPI";
	}

	@PostMapping("/square")
	public int squareNum(@RequestParam int num) {
		System.out.println("Number :" + num);
		System.out.println("Square :" + num * num);
		return num * num;

	}
	@PostMapping("/add")
	public int squareNum(@RequestParam("num1") int num1,@RequestParam("num2") int num2) {
		System.out.println("Number1 :" + num1);
		System.out.println("Number2 :" + num2);
		int sum = num1+num2;
		System.out.println("Sum :" + sum);
		return sum;

	}
}
