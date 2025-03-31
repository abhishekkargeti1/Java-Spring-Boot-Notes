package com.vsproject.vsproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class viewController {
    
    @RequestMapping("/test")
    @ResponseBody
    public String defaultController(){
        System.out.println("Hello World");
        return "This First Vs Spring Boot Project";
    }


}
