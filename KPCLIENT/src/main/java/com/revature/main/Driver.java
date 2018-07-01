package com.revature.main;

import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Phone;

public class Driver {
	
    private static final Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String getRequestUrl = "http://localhost:8084/phones/1325";
		
	    try {
	        Phone phone = restTemplate.getForObject(getRequestUrl, Phone.class);
	        log.info("Resource consumption successful");
	        log.info(phone.toString());
	    } catch(Exception e) {
	        log.error("Resource consumption unsuccessful");
	    }
	    
		String postRequestUrl = "http://localhost:8084/phones";
		Phone newPhone = new Phone(1332,"Apple","IPhone 4",2010);
		
	    try {
	        Phone phoneAdd = restTemplate.postForObject(postRequestUrl, newPhone, Phone.class);
	        log.info("Resource consumption successful");
	        log.info("'Posted':" + phoneAdd.toString());
	    } catch(Exception e) {
	        log.error("Resource consumption unsuccessful");
	    }
	       
	       
	
		
	}

}