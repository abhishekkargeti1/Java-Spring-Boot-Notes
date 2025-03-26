package com.FirstProjectSI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class viewController {

	@RequestMapping("/test")
	@ResponseBody
	public String getFirstView() {
		return "First Controller";
	}
}
