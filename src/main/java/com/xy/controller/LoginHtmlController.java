package com.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginHtmlController {

	@RequestMapping("signInPage")
	public String signInPage() {
		return "login/login";
	}
	
	@RequestMapping("registerPage")
	public String registerPage() {
		return "login/login";
	}
	
	@RequestMapping("fbkPage")
	public String fbkPage() {
		return "login/login";
	}
	
}
