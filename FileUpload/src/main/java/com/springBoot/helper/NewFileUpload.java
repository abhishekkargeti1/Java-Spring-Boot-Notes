package com.springBoot.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class NewFileUpload {
	//private final String uploadDir = "D:\\My Personal Work\\Spring Boot\\FileUpload\\src\\main\\resources\\static\\image";
	 private final String uploadDir;

	    public NewFileUpload() throws IOException {
	        // Use relative path instead of classpath resource
	        this.uploadDir = "static/images";
	        
	        // Create directory if it doesn't exist
	        File directory = new File(uploadDir);
	        if (!directory.exists()) {
	            if (!directory.mkdirs()) {
	                throw new IOException("Failed to create upload directory");
	            }
	        }
	    }
    
	public boolean uploadFile(MultipartFile file) {
		try {
			//String uploadDir = new ClassPathResource("static/images").getURL().getPath();
			System.out.println("Upload File "+uploadDir);
			Files.copy(file.getInputStream(), Paths.get(uploadDir+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}