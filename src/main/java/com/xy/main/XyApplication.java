package com.xy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xy.config.Configuration;

@SpringBootApplication(scanBasePackageClasses = {Configuration.class})
public class XyApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyApplication.class, args);
	}

	
	

}
