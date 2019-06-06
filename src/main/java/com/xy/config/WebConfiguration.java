package com.xy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.xy.controller","com.xy.service"})
public class WebConfiguration {
}
