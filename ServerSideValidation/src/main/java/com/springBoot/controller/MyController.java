package com.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springBoot.entites.UserDetails;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@GetMapping("/form")
	public String getForm(Model model) {
		System.out.println("Hello I am Form Handler");
		model.addAttribute("loginData", new UserDetails());
		return "form";
	}
	
	@PostMapping("/submit")
	public String getFormDetails(@Valid @ModelAttribute("UserDetails")UserDetails details,BindingResult result,Model model) {
		System.out.println("Hello I am Form Details Handler");
		if(result.hasErrors()) {
			System.out.println("Result is "+result);
			model.addAttribute("error",result);
			return"form";
		}
		System.out.println("UserDetails "+details);
		return "success";
	}
}
