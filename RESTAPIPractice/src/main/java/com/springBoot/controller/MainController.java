package com.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entities.UserDetails;
import com.springBoot.service.UserService;

@RestController
public class MainController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<UserDetails> getAllUser(){
		System.out.println("All User Details Controller");
		return service.getAllUser();
	}
	
	
	@GetMapping("/user/{id}")
	public UserDetails getUserById(@PathVariable("id")int id) {
		System.out.println("User Details By Id");
		return service.getUserById(id);
		
	}
	
	@PostMapping("/addUser")
	public void AddUser(@RequestBody UserDetails details) {
		service.addNewUser(details);
	}
	
	
	
	
}
