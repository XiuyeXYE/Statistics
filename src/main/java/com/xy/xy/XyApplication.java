package com.xy.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.xy.controller")
public class XyApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyApplication.class, args);
	}

}
