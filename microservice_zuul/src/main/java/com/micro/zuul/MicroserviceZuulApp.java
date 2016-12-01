package com.micro.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
@RefreshScope  //This annotation allow to zuul to detect changes in zuul.yml (from config server) and auto refresh the spring scope with this changes
public class MicroserviceZuulApp {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceZuulApp.class, args);
	}
}
