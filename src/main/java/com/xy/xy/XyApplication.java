package com.xy.xy;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.Subject;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xiuye.util.cls.TypeUtil;
import com.xiuye.util.log.LogUtil;

@Configuration
@SpringBootApplication
@ControllerAdvice
@ComponentScan("com.xy.controller")
public class XyApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyApplication.class, args);
	}

	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String handleException(AuthorizationException e, Model model) {

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

	@Bean
	public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		/**
		 * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
		 * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。 加入这项配置能解决这个bug
		 */
		creator.setUsePrefix(true);
		return creator;
	}

	@Bean
	public Realm realm() {
		TextConfigurationRealm realm = new TextConfigurationRealm();
		realm.setUserDefinitions("joe.coder=password,user\n" + "jill.coder=password,admin");

		realm.setRoleDefinitions("admin=read,write\n" + "user=read");
		realm.setCachingEnabled(true);
		return realm;
	}

	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
		chainDefinition.addPathDefinition("/login.html", "authc"); // need to accept POSTs from the login form
		chainDefinition.addPathDefinition("/logout", "logout");
		return chainDefinition;
	}

	@ModelAttribute(name = "subject")
	public Subject subject() {
		LogUtil.log("@ModelAttribute execute");
		return SecurityUtils.getSubject();
	}

}
