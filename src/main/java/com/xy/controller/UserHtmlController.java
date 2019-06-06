package com.xy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiuye.util.log.LogUtil;

@Controller
public class UserHtmlController {

	@RequiresAuthentication
	@RequestMapping("accountInfo")
	public String getUserInfo(Model model) {
		Subject subject = SecurityUtils.getSubject();
		String name = "World";
		PrincipalCollection principalCollection = subject.getPrincipals();

		if (principalCollection != null && !principalCollection.isEmpty()) {
			name = principalCollection.getPrimaryPrincipal().toString();
		}
		model.addAttribute("name", name);
		return "user/accountInfo";
	}

}
