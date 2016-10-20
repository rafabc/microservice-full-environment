package com.micro.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
public class ClientManagerApp {

	public static void main(String[] args) {
		SpringApplication.run(ClientManagerApp.class, args);
	}
}
