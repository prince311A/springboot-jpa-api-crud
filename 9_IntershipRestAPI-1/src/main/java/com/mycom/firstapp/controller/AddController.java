package com.mycom.firstapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.firstapp.pojo.AddRequest;

@RestController
@RequestMapping("/api")
public class AddController {
	@PostMapping("/add")
public int add(@RequestBody AddRequest request) {
	System.out.println("Incoming Values are"+" || num1: "+request.getNum1()+" | num2: "+request.getNum2());
	int sum = request.getNum1()+request.getNum2();
	System.out.println("Sum: "+sum);
	return sum;
}
}
