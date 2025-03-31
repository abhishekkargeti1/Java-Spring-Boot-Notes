package com.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class viewController {

	@RequestMapping("/")
	public String getDefaultView() {
		System.out.println("Hello World");
		return "index";
	}
	
	@RequestMapping("/contact")
	public String getContactView() {
		System.out.println("Hello2 World");
		return "contact";
	}
}
