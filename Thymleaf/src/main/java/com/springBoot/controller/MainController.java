package com.springBoot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/home")
	public String defaultView(Model model ) {
		System.out.println("Hello I am Default Handler");
		model.addAttribute("name","Abhishek Kargeti");
		model.addAttribute("Date",new Date().toLocaleString());
		return "index";
	}
}
