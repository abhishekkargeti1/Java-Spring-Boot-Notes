package com.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entites.UserDetails;
import com.springBoot.service.UserService;

@RestController
public class APIController {

	@Autowired
	UserService service;

	@PostMapping("/userDetails")
	public ResponseEntity<UserDetails> insertData(@RequestBody UserDetails details) {
		UserDetails datareceived = service.insertData(details);
		if (datareceived != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(datareceived);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
