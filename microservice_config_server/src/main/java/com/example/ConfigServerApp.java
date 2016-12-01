package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigServer
@EnableEurekaClient
@RefreshScope
public class ConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApp.class, args);
	}
}
