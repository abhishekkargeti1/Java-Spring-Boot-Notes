package com.spring.security.JWT.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.JWT.configuration.JwtFilter;
import com.spring.security.JWT.entites.User;
import com.spring.security.JWT.entites.xyz;
import com.spring.security.JWT.serviceImpl.LoginServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class loginController {
	@Autowired
	LoginServiceImpl service;

	@Autowired
	JwtFilter key;

	@GetMapping("/login")
	public ResponseEntity<Map<String, String>> getLogin(@RequestBody User details) {
		String email = details.getEmail().trim();
		String password = details.getPassword().trim();

		List<User> users = service.getUserLogin(email, password);
		System.out.println("Details in Controller " + users);

		if (!users.isEmpty()) {
			String token = key.generateToken(email);
			Map<String, String> response = new HashMap<>();
			response.put("token", token);
			response.put("message", "Login Successfully");
			return ResponseEntity.ok(response);
		} else {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "Invalid credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}

	}

	@GetMapping("/details")
	public ResponseEntity<?> getDetails() {
		Iterable<xyz> details = service.getDetails();
		if (details.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(details);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");			
		}
	}

}
