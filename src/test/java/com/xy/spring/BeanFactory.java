package com.xy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xiuye.util.log.LogUtil;
import com.xy.spring.bean.A;
import com.xy.spring.bean.B;


@Configuration
@ComponentScan({
	"com.xy.spring.bean"
})
public class BeanFactory {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanFactory.class);
		A a = ac.getBean(A.class);
		a.sayHello();
		org.springframework.beans.factory.BeanFactory f = ac.getAutowireCapableBeanFactory();
		a = f.getBean(A.class);
		a.sayHello();
		B b = f.getBean(B.class);
		LogUtil.log(b);
		LogUtil.log(f.getBean("&b"));
		LogUtil.log(f.getBean("b"));
	}

}
