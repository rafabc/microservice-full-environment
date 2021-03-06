package com.micro.car.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.micro.car.dto.Car;

@Service
public class CarService {
	
	List<Car> cars;
	

	
	
	@PostConstruct
	public void init() {
		
		 cars = new ArrayList<Car>();
		 cars.add(new Car("1", "For", "Mondeo", "Gris", "2015", "175"));
		 cars.add(new Car("2", "Fiat", "Bravo", "Azul", "2001", "105"));
		 cars.add(new Car("3", "Alfa Romeo", "159", "Negro", "2008", "150"));
		 cars.add(new Car("4", "Ferrari", "GTO", "Rojo", "1995", "350"));
		 cars.add(new Car("5", "Mercedes", "350", "Negro", "2005", "220"));
		 cars.add(new Car("6", "Alfa Romeo", "147", "Negro", "2008", "105"));
	}
	
	public Car getCarById(String id) {
		
		return cars.get(Integer.valueOf(id) - 1);
	}
	
	public List<Car> getCars() {
		
		return cars;
	}
	
}
