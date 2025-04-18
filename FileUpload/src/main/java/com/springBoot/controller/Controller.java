package com.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springBoot.helper.FileUpload;
import com.springBoot.helper.NewFileUpload;

@RestController
public class Controller {

	@Autowired
	private NewFileUpload upload;

	@Autowired
	private FileUpload upload1;

	private boolean status = false;

	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File Not Found");
			} else if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only jpeg is allowed");
			} else {
				// status = upload1.uploadFile(file);
				status = upload.uploadFile(file);

				if (status) {
//					return ResponseEntity.status(HttpStatus.OK).body("File Uploaded Successfully");
					return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
							.path(file.getOriginalFilename()).toUriString());

				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Error File not Uploaded Successfully");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Occured");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
		}
	}
}