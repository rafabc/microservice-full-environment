package com.micro.car.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.car.dto.Car;
import com.micro.car.listener.PortListener;
import com.micro.car.service.CarService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.exception.FallbackDefinitionException;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	
	@Autowired
	Environment environment;

	
	
    @Inject
    private org.springframework.boot.autoconfigure.web.ServerProperties serverProperties;


	@HystrixCommand(fallbackMethod = "defaultCarById")
	@RequestMapping("/car/{id}")
	public Car getCar(@PathVariable("id") String id) {

		throw new FallbackDefinitionException("");

		// return carService.getCarById(id);

		// return cars.get(Integer.valueOf(id) - 1);
	}

	public Car defaultCarById(String id) {

		PortListener portListener = new PortListener();
		
		System.out.println("puerto consumido: " + getPort());

		return new Car(id, String.valueOf(portListener.getPort()), getPort(), "def", "def", "def");
	}

	@RequestMapping("/")
	public List<Car> getIndex() {

		return carService.getCars();
	}
	
	
	
	public String getPort() {
	    final Integer randomPort = environment.getProperty("local.management.port", Integer.class);
	    return randomPort.toString();
	}
}
