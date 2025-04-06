package com.springBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entities.UserDetails;
import com.springBoot.service.UserService;

@RestController
public class MainController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDetails>> getAllUser(){
		System.out.println("All User Details Controller");
		
		List<UserDetails> details = service.getAllUser();
		if(details.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
		}
		
		return ResponseEntity.of(Optional.of(details));
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDetails> getUserById(@PathVariable("id")int id) {
		System.out.println("User Details By Id");
		 UserDetails details = service.getUserById(id);
		 if(details ==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 
		return ResponseEntity.of(Optional.of(details));
		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDetails> AddUser(@RequestBody UserDetails details) {
		UserDetails newDetails = null;
		try {
			newDetails=service.addNewUser(details);
			return ResponseEntity.status(HttpStatus.CREATED).body(newDetails);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id")int id) {
		service.getUserDeleteById(id);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public void deleteAllUser() {
		service.deleteUser();
	}
	
	
	
	
	/*
	 * @PutMapping("/updateUser/{id}/{name}") public void
	 * updateUser(@PathVariable("id")int id,@PathVariable("name")String name) {
	 * service.updateUserDetailsById(id, name); }
	 */
	
	
	
	@PutMapping("/updateUser/{id}")
	public UserDetails getUpdateUserDetails(@PathVariable("id")int id,@RequestBody UserDetails details ) {
		service.updateDetailsById(id, details);
		return details;
	}
	
}
