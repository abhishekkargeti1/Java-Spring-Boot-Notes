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
	

	@RequestMapping("/home")
	public String gethomeView() {
		System.out.println("Hello World 2");
		return "index";
	}
	
}
