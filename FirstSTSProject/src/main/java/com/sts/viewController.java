package com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class viewController {

	@RequestMapping("/test")
	@ResponseBody
	public String defaultView() {
		System.out.println("Hell I am Default View");
		return "this first Controller";
	}
	
}
