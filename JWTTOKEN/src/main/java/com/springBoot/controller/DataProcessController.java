package com.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springBoot.Service.JWTService;
import com.springBoot.entities.UserDetails;
import com.springBoot.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class DataProcessController {

	@Autowired
	JWTService service;
	String errorMesage = null;

	@PostMapping("/register")
	public String getUserData(@Valid @ModelAttribute("UserDetails") UserDetails details, BindingResult error,
			HttpSession session) {
		System.out.println("Details are " + details);
		if (error.hasErrors()) {
			for (FieldError er : error.getFieldErrors()) {
				Message message = new Message(er.getDefaultMessage(), "alert", "alert-danger");
				session.setAttribute("message", message);
			}
		} else {
			if (!service.checkEmailExist(details.getEmail())) {
				System.out.println("In side If condition  ");				
				boolean status = service.insertDetailsData(details);
				if (status == true) {
					Message message = new Message("Successfully Registrated", "success", "alert-success");
					session.setAttribute("message", message);
					return "redirect:/form";
				}
			} else {
				System.out.	println("Hello Error ");
				Message message = new Message("Email Already Exists !", "alert", "alert-danger");
				session.setAttribute("message", message);
				return "redirect:/form";

			}
		}

		return "redirect:/form";
	}
}
