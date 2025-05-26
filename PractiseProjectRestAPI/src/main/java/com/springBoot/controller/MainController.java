package com.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entities.Details;
import com.springBoot.service.DetailsService;

import jakarta.validation.Valid;

@RestController
public class MainController {
	
	@Autowired
	private DetailsService service;
	
	private List<String> errorsList = new ArrayList<>();
	
	@PostMapping("/addUser")
	public ResponseEntity<?> insertData(@Valid @RequestBody Details details, BindingResult error){
	
		if(error.hasErrors()) {
			errorsList.clear();
			for(FieldError e : error.getFieldErrors()) {
				errorsList.add(e.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsList);							
			
		}
		
		
		
		Details savedUser = service.insertUserDetails(details);
		if(savedUser!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(savedUser);			
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
		
		
	}

}
