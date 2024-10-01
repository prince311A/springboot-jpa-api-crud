package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.hibernate.boot.model.internal.AbstractPropertyHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	// this path is static path or for local server
	public final String UPLOAD_DIR = "C:\\Users\\Dell\\Documents\\workspace-spring-tool-suite"
			+ "-4-4.24.0.RELEASE\\8_SpringBootWithRestAPI-JPA\\src\\main\\resources\\static\\image";
	// Now we have to choose the path dynamically mean when we deploy our project in server that the file should upload in 
	// 'target' folder path that 'image' folder
	
	public final String UPLOAD_DIR2 = new ClassPathResource("static/image").getFile().getAbsolutePath();
	public FileUploadHelper() throws IOException {} // this is to handle exception occurred by .getFile()
	
	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		
		try {
			// reading all the data from multi-part file and store in array of byte
//		InputStream stream = file.getInputStream();
//		byte[] data = new byte[stream.available()];
//		stream.read(data); // reads all the data from stream and stores to byte data
//		
//		// Now all the write all the data from byte of data to file
//		FileOutputStream fStream = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//		fStream.write(data);
//		fStream.flush();
//		fStream.close();
//		f = true;
			
	    // New Way using Nio package
			// 1st argument --> kaha se copy krna hai i.e multi-part file
			// 2nd argument  ---> kaha per paste karna i.e path+fileName
			// 3rd argument ---> standard option replace agr hai to ni to create
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
}
