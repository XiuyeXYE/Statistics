package com.xy.config;

import java.util.Map;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xiuye.util.cls.TypeUtil;
import com.xiuye.util.log.LogUtil;


@ControllerAdvice
public class AdviceConfiguration {

	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String handleException403(AuthorizationException e, Model model) {

		// you could return a 404 here instead (this is how github handles 403, so the
		// user does NOT know there is a
		// resource at that location)
		LogUtil.log("AuthorizationException was thrown", e);

		Map<String, Object> map = TypeUtil.createMap();
		map.put("status", HttpStatus.FORBIDDEN.value());
		map.put("message", "No message available");
		model.addAttribute("errors", map);

		return "error";
	}
	
	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException500(AuthorizationException e, Model model) {
		
		return this.handleException403(e, model);
				
	}
	
	

	
}
