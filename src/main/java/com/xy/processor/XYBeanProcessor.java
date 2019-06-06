package com.xy.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import com.xiuye.util.log.LogUtil;
import com.xy.bean.Global;

public class XYBeanProcessor implements BeanDefinitionRegistryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		LogUtil.log("enter postProcessBeanFactory");
	
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		LogUtil.log("enter postProcessBeanDefinitionRegistry");
		LogUtil.log("============================");
		LogUtil.log("BeanDefinitionRegistry =",registry);
		LogUtil.log("============================");
		GenericBeanDefinition gbd = new GenericBeanDefinition();
		gbd.setBeanClass(Global.class);
		MutablePropertyValues mov = new MutablePropertyValues();
		mov.add("g", "Hello World!");
		gbd.setPropertyValues(mov);
//		gbd.setBeanClassName(beanClassName);
		registry.registerBeanDefinition("global", gbd);
		
	}

}
