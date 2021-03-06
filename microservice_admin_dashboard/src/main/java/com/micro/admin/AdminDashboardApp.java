package com.micro.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableAutoConfiguration
@RefreshScope
public class AdminDashboardApp {

	public static void main(String[] args) {
		SpringApplication.run(AdminDashboardApp.class, args);
	}
	
	
	
}
