package com.micro.zuul.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.micro.zuul.core.CurrentUserHandlerMethodArgumentResolver;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	CurrentUserHandlerMethodArgumentResolver currentUserHandlerMethodArgumentResolver;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error").setViewName("error");
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
    	argumentResolvers.add(currentUserHandlerMethodArgumentResolver);
    }

}