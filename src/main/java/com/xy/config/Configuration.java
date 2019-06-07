package com.xy.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootConfiguration
@EnableTransactionManagement
@EnableRetry
@EnableScheduling
@EnableJpaAuditing
@EnableJpaRepositories
@EnableAsync
@EnableMBeanExport
@EnableCaching
@EnableWebSocket
public class Configuration {

}
