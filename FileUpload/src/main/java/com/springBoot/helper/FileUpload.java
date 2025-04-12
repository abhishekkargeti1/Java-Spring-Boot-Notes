package com.springBoot.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {

	private final String uploadDir = "D:\\My Personal Work\\Spring Boot\\FileUpload\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile file) {
		try {
			InputStream fileData = file.getInputStream();
			byte data[]= new byte[fileData.available()];
			FileOutputStream fos = new FileOutputStream(uploadDir+File.separator+file.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
