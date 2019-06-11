package com.xy.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class B implements FactoryBean<String> {

	@Override
	public String getObject() throws Exception {
		return "Hello,I am B from getObject!";
	}

	@Override
	public Class<?> getObjectType() {
		return String.class;
	}

}
