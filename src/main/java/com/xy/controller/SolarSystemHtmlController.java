package com.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SolarSystemHtmlController {

	@RequestMapping("solar")
	public String solar() {
		return "solarSystem/index";
	}
	
}
