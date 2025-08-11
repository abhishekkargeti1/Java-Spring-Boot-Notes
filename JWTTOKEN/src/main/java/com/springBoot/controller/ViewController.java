package com.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("")
	public String getDefaultView() {
		System.out.println("Hello First Controller");
		return"RegistrationForm";
	}
	@GetMapping("/login")
	public String getloginView() {
		System.out.println("Hello First Controller");
		return"login";
	}
	
	@GetMapping("/form")
	public String getFormView() {
		System.out.println("Hello I am Default Controller");
		return "RegistrationForm";
	}
	
}
