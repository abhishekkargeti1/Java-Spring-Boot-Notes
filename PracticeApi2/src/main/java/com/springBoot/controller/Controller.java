package com.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.dao.UserDao;
import com.springBoot.entities.UserDetails;

@RestController
public class Controller {

	@Autowired
	UserDao dao;
	
	
	@PostMapping("/userDetails")
	public ResponseEntity<UserDetails> addUserDetails(@RequestBody UserDetails details){
		UserDetails detailsSaved = dao.save(details);
			if(detailsSaved == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(detailsSaved);
	
	}
	
}
