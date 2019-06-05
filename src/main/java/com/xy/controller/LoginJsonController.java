package com.xy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiuye.util.cls.TypeUtil;
import com.xiuye.util.log.LogUtil;
import com.xy.bean.User;

@RestController
public class LoginJsonController {

	@PostMapping("signIn")
	public Map<String, Object> signIn(User user) {

		Subject subject = SecurityUtils.getSubject();

		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = TypeUtil.newInstance(UsernamePasswordToken::new, user.getAccount(),
					user.getPassword());
			subject.login(token);
		}
		Map<String, Object> m = TypeUtil.createMap();
		m.put("success", true);
		m.put("msg", "Sign in OK!");
		m.put("status", 200);
		m.put("data", "none");
		return m;

	}

}
