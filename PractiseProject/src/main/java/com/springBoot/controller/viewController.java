package com.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entites.Details;
import com.springBoot.service.DetailsService;

import jakarta.validation.Valid;

@RestController
public class viewController {
	@Autowired
	DetailsService service;
	List<String> errors = new ArrayList<>();

	@GetMapping("/")
	public String hello() {
		return "Hello, Spring Boot!";
	}

	@PostMapping("/addUser")
	public ResponseEntity<?> saveDetails(@Valid @RequestBody Details details, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("Helo World");
			errors.clear();
			for (FieldError error : result.getFieldErrors()) {
				errors.add(error.getDefaultMessage());
			}

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

		}

		Details d = service.addUser(details);
		if (d != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(d);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
