package com.springBoot.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class NewFileUpload {
	private final String uploadDir = "D:\\My Personal Work\\Spring Boot\\FileUpload\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), Paths.get(uploadDir+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
