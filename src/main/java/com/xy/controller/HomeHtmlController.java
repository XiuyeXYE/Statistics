package com.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeHtmlController {

	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
}
