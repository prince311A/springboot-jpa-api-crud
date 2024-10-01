package com.api.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.FileUploadHelper;

import jakarta.servlet.Servlet;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize()); // return in bytes
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());

		// check if the file is empty or not
		try {
			
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain file");
		}
//		if (!file.getContentType().equals("image/jpeg")) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain jpeg type");
//		}
		// File Upload Code
		// Step 1--> Where to upload file on server (UPLOAD_DIR)
		// in my case
		// C:\Users\Dell\Documents\workspace-spring-tool-suite-4-4.24.0.RELEASE\8_SpringBootWithRestAPI-JPA\src\main\resources\static
		boolean status = fileUploadHelper.uploadFile(file);
		System.out.println(status);
		if(status) {
			System.out.println("File Successfully Upload");
//			return ResponseEntity.ok("File Successfully Upload");
			// lets return the path where image is uploaded
			// ServletUriComponentsBuilder.fromCurrentContextPath() --> this will give the till server i.e localhost:8080
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().
					path("/image/").path(file.getOriginalFilename()).toUriString());
		}
		else {
			System.out.println("Something Went Wrong");
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
	}
}
