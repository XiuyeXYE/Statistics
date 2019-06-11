package com.xy.spring.bean;

import org.springframework.stereotype.Component;

import com.xiuye.util.log.LogUtil;

@Component
public class A {

	public void sayHello() {
		LogUtil.log("Hello");
	}
	
}
