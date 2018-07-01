package com.revature.main;

import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Phone;

public class Driver {
	
    private static final Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String getRequestUrl = "http://localhost:5000/phones/1332";
		
	    try {
	        Phone phone = restTemplate.getForObject(getRequestUrl, Phone.class);
	        log.info("Resource consumption successful");
	        log.info(phone.toString());
	    } catch(Exception e) {
	        log.error("Resource consumption unsuccessful");
	    }
	    
		String postRequestUrl = "http://localhost:5000/phones";
		Phone newPhone = new Phone(1332,"Apple","IPhone 4",2010);
		
	    try {
	    	//Create
	        Phone phoneAdd = restTemplate.postForObject(postRequestUrl, newPhone, Phone.class);
	        log.info("Resource consumption successful");
	        log.info("'Posted':" + phoneAdd.toString());
	    } catch(Exception e) {
	        log.error("Resource consumption unsuccessful");
	    }
	    //Update
	    Phone newChange = new Phone(1332,"Apple","IPhone 4",2013);
	    try {
	    	 restTemplate.put(postRequestUrl, newChange);
	    	 log.info("Update Success");
	    }catch(Exception e) {
	    	log.error("Fail");
	    }
	    try {
	    	restTemplate.exchange(postRequestUrl, HttpMethod.DELETE, new HttpEntity<Phone>(newChange), Phone.class);
	    	log.info("It's gone");
	    }catch(Exception e){
	    	log.error("ITS STILL THERE");
	    }
	}

}