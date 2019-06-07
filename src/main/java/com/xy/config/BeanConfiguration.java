package com.xy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xiuye.util.cls.TypeUtil;
import com.xy.processor.XYBeanProcessor;

@Configuration
public class BeanConfiguration {

	@Bean
	public static XYBeanProcessor xyBeanProcessor() {
		return TypeUtil.newInstance(XYBeanProcessor::new);
	}

}
