package com.xy.shiro;

import javax.annotation.PostConstruct;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.config.ShiroAnnotationProcessorConfiguration;
import org.apache.shiro.spring.config.ShiroBeanConfiguration;
import org.apache.shiro.spring.config.ShiroConfiguration;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.xiuye.util.log.LogUtil;

@Component
class SimpleService {

	@RequiresPermissions("write")
	public void writeRestrictedCall() {
		LogUtil.log("executing method that requires the 'write' permission");
	}

	@RequiresPermissions("read")
	public void readRestrictedCall() {
		LogUtil.log("executing method that requires the 'read' permission");
	}
}

@Component
class QuickStart {

	@Autowired
	private SecurityManager securityManager;

	@Autowired
	private SimpleService simpleService;

	public void run() {

		// get the current subject
		Subject subject = SecurityUtils.getSubject();

		// Subject is not authenticated yet
		Assert.isTrue(!subject.isAuthenticated());

		// login the subject with a username / password
		UsernamePasswordToken token = new UsernamePasswordToken("joe.coder", "password");
		subject.login(token);

		// joe.coder has the "user" role
		subject.checkRole("user");

		// joe.coder does NOT have the admin role
		Assert.isTrue(!subject.hasRole("admin"));

		// joe.coder has the "read" permission
		subject.checkPermission("read");

		// current user is allowed to execute this method.
		simpleService.readRestrictedCall();

		try {
			// but not this one!
			simpleService.writeRestrictedCall();
		} catch (AuthorizationException e) {
			LogUtil.log("Subject was NOT allowed to execute method 'writeRestrictedCall'");
		}

		// logout
		subject.logout();
		Assert.isTrue(!subject.isAuthenticated());
	}

	/**
	 * Sets the static instance of SecurityManager. This is NOT needed for web
	 * applications.
	 */
	@PostConstruct
	private void initStaticSecurityManager() {
		SecurityUtils.setSecurityManager(securityManager);
	}
}

@Configuration
@ComponentScan("com.xy.shiro")
@Import({ ShiroBeanConfiguration.class, ShiroConfiguration.class, ShiroAnnotationProcessorConfiguration.class })
public class Demo2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo2.class);
        context.getBean(QuickStart.class).run();
	}

	/**
	 * Example hard coded Realm bean.
	 * 
	 * @return hard coded Realm bean
	 */
	@Bean
	public Realm realm() {

		TextConfigurationRealm realm = new TextConfigurationRealm();
		realm.setUserDefinitions("joe.coder=password,user\n" + "jill.coder=password,admin");

		realm.setRoleDefinitions("admin=read,write\n" + "user=read");
		realm.setCachingEnabled(true);
		return realm;
	}

}
