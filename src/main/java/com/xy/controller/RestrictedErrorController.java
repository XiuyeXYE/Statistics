package com.xy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.xiuye.util.cls.TypeUtil;

public class RestrictedErrorController extends BasicErrorController {

	public RestrictedErrorController(org.springframework.boot.web.servlet.error.ErrorAttributes errorAttributes,
			ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
	}

	private static final String ERROR_PATH = "/error";

	@Autowired
	private DefaultErrorAttributes errorAttributes;

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	@RequestMapping(ERROR_PATH)
	String error(HttpServletRequest request, Model model) {
		Map<String, Object> errorMap = errorAttributes
				.getErrorAttributes(TypeUtil.newInstance(ServletWebRequest::new, request), false);
		model.addAttribute("errors", errorMap);
		return "error";
	}
}
