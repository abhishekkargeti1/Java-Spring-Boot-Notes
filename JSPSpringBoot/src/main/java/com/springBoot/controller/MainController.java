package com.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String defaultController() {
		System.out.println("This is home Controller");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contactPage() {
		System.out.println("This is Contact Controller");
		return "contact";
	}
}
