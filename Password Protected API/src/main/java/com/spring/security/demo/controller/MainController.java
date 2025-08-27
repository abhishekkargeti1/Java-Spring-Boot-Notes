package com.spring.security.demo.controller;

import com.spring.security.demo.enities.UserDetails;
import com.spring.security.demo.service.DetailsService;
import com.spring.security.demo.serviceImpl.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vamps")
public class MainController {

    @Autowired
    DetailsServiceImpl service;


    @GetMapping("/dataList")
    public Iterable<UserDetails> getData() {
        Iterable<UserDetails> details = service.getDetails();
        System.out.println("Hello Abhishek");
        System.out.println("Details in Controller "+details);
        return details;

    }

}
