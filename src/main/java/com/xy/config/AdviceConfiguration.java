package com.xy.config;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xiuye.util.cls.TypeUtil;
import com.xy.bean.MapResult;
import com.xy.util.BeanFactoryUtil;


//@ControllerAdvice
@RestControllerAdvice
public class AdviceConfiguration {

	//权限
	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
//	@ResponseBody
	public MapResult handleAuthorizationException(AuthorizationException e, Model model) {

		// you could return a 404 here instead (this is how github handles 403, so the
		// user does NOT know there is a
		// resource at that location)

//		Map<String, Object> map = TypeUtil.createMap();
//		map.put("status", HttpStatus.FORBIDDEN.value());
//		map.put("message", "No permissions!");
//		model.addAttribute("errors", map);
		Map<String, Object> data = TypeUtil.createMap();
		data.put("url","error/error");
		return BeanFactoryUtil.mapResult(false, data, "No permissions!", HttpStatus.FORBIDDEN.value());
//		return "error/error";
	}
	
	//身份认证
	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
//	@ResponseBody
	public MapResult handleAuthenticationException(AuthenticationException e, Model model) {

		// you could return a 404 here instead (this is how github handles 403, so the
		// user does NOT know there is a
		// resource at that location)

//		Map<String, Object> map = TypeUtil.createMap();
//		map.put("status", HttpStatus.FORBIDDEN.value());
//		map.put("message", "Illegal user!");
//		model.addAttribute("errors", map);
		Map<String, Object> data = TypeUtil.createMap();
		data.put("url","error/error");
		return BeanFactoryUtil.mapResult(false, data, "Illegal user!", HttpStatus.FORBIDDEN.value());
//		return "error/error";
	}
	//身份认证
	@ExceptionHandler(UnauthenticatedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public MapResult handleUnauthenticatedException(UnauthenticatedException e, Model model) {
		
		// you could return a 404 here instead (this is how github handles 403, so the
		// user does NOT know there is a
		// resource at that location)
		
//		Map<String, Object> map = TypeUtil.createMap();
//		map.put("status", HttpStatus.FORBIDDEN.value());
//		map.put("message", "Illegal user!");
//		model.addAttribute("errors", map);
		Map<String, Object> data = TypeUtil.createMap();
		data.put("url","error/error");
		return BeanFactoryUtil.mapResult(false, data, "Illegal user!", HttpStatus.FORBIDDEN.value());
//		return "error/error";
	}
	
	@ModelAttribute(name = "subject")
	public Subject subject() {
		return SecurityUtils.getSubject();
	}

	
}
