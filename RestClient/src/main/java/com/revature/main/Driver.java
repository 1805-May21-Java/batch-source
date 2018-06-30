package com.revature.main;

import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Car;

public class Driver {
	
    private static final Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String getRequestUrl = "http://localhost:8084/cars/1325";
		
	    try {
	        Car car = restTemplate.getForObject(getRequestUrl, Car.class);
	        log.info("Resource consumption successful");
	        log.info(car.toString());
	    } catch(Exception e) {
	        log.error("Resource consumption unsuccessful");
	    }
	    
		String postRequestUrl = "http://localhost:8084/cars";
		Car newCar = new Car(3,"Mazda","626",1996);
		
	    try {
	        Car addedCar = restTemplate.postForObject(postRequestUrl, newCar, Car.class);
	        log.info("Resource consumption successful");
	        log.info("'Posted':" + addedCar.toString());
	    } catch(Exception e) {
	        log.error("Resource consumption unsuccessful");
	    }
	       
	       
	
		
	}

}
