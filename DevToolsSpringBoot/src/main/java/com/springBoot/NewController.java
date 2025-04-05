package com.springBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		int a = 200;
		int b= 10;
		int c = 910;
		int d = 510;
		return "C is "+(a+b+c+d);
	}

}
