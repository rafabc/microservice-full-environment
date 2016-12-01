package com.micro.client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.client.dto.Car;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class ClientService {

    @Autowired
    private RestTemplate template;
    
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
    
    
    private final static String SERVICE_CAR_URL = "http://servicio-car/car/{id}";
	
    @HystrixCommand(fallbackMethod = "defaultCar")
	public Car getCar(String id) {
    	

    	ServiceInstance instance = loadBalancerClient.choose("servicio-car");

        
        
        
		
    	ResponseEntity<Car> response = null;
    	/*
		for (int i=0; i<100; i++){
			
	    	System.out.println("instance uri: " + instance.getUri()); 
	    	System.out.println("instance secure: " + instance.isSecure()); 
	    	
	    	System.out.println("service url: " + serviceUrl());
			
			
			response = template.exchange(SERVICE_CAR_URL, HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {}, id);
		}
		*/
		
		response = template.exchange(SERVICE_CAR_URL, HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {}, id);

		return response.getBody();
		
	}
    
    public Car defaultCar(String e) {
        //return new Car("default car","2","3","4");
        
    	ResponseEntity<Car> response = null;
        response = template.exchange(SERVICE_CAR_URL, HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {}, 5);

		return response.getBody();
    	
    }
    
    
    
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("servicio-car");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
	
	
	
}
