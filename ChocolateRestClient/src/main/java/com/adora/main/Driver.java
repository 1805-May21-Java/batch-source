package com.adora.main;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.adora.beans.Chocolate;




public class Driver {
	
	private static final Logger log = LoggerFactory.getLogger(Driver.class);
	static String baseUrl = "https://jeankinsbeanstalk-env-2.ppmgmmdwf2.us-east-2.elasticbeanstalk.com/chocolate";
	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		
		//do stuff
		
		//get a chocolate
		Chocolate c1 = getChocolateById(2);
		c1.toString();
		
		
		//make a new chocolate
		Chocolate c2 = new Chocolate(2, "Hershey with Almonds", 350, "milk");
		addChocolate(c2);
		// modify the new chocolate
		
		//delete the new chocolate
		
	}

	public static List<Chocolate> getAllChocolate(RestTemplate restTemplate) {
		ResponseEntity<Chocolate[]> chocolateResponse = 
					restTemplate.getForEntity(baseUrl, Chocolate[].class);
		Chocolate[] chocolates = chocolateResponse.getBody();
		List<Chocolate> chocolateList = Arrays.asList(chocolates);
		
		return chocolateList;
	}
	
	
	public static Chocolate getChocolateById(int id) {
		Chocolate chocolate =  
				restTemplate.getForObject(baseUrl + "/" + id, Chocolate.class);
		log.info("chocolate " + id + " received");
		log.info(chocolate.toString());
		return chocolate;
	}
	
	
	public static void addChocolate(Chocolate newChocolate) {

		restTemplate.postForObject(baseUrl, newChocolate, Chocolate.class);
		log.info("chocolate added");
	
	}
	
	
	public static void modifyChocolate(Chocolate chocolate) {
		HttpEntity<Chocolate> chocolateUpdate = new HttpEntity<>(chocolate);
		restTemplate.exchange( baseUrl, HttpMethod.PUT, chocolateUpdate, Chocolate.class);
		log.info("chocolate modified");
	}
	
	
	public static void deleteChocolate(int id) {
		restTemplate.delete(baseUrl + "/" + id );
		log.info("chocolate " + id + " deleted");
	}
}
