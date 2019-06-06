package com.xy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiuye.util.cls.TypeUtil;
import com.xiuye.util.log.LogUtil;
import com.xy.bean.MapResult;
import com.xy.bean.User;
import com.xy.util.BeanFactoryUtil;

@RestController
public class LoginJsonController {

	@PostMapping("signIn")
	public MapResult signIn(User user) {

		Subject subject = SecurityUtils.getSubject();

		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = TypeUtil.newInstance(UsernamePasswordToken::new, user.getAccount(),
					user.getPassword());
			token.setRememberMe(user.isRemme());
			subject.login(token);
		}
		Map<String,Object> data = TypeUtil.createMap();
		data.put("url", "accountInfo");
		return BeanFactoryUtil.mapResult(true, data, "Sign in OK!", 200);

	}
	@RequiresUser
	@RequestMapping("user/logout")
	public MapResult logout() {
		Subject subject = SecurityUtils.getSubject();

		if (subject.isAuthenticated()) {
			subject.logout();
		}
		Map<String,Object> data = TypeUtil.createMap();
		data.put("url", "signInPage");
		return BeanFactoryUtil.mapResult(true, data, "Sign in OK!", 200);
	}

}
