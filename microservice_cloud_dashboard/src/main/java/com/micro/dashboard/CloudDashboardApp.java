package com.micro.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.github.vanroy.cloud.dashboard.config.EnableCloudDashboard;



@SpringBootApplication
@EnableCloudDashboard
@EnableAutoConfiguration
@RefreshScope
public class CloudDashboardApp {

	public static void main(String[] args) {
		SpringApplication.run(CloudDashboardApp.class, args);
	}
}
