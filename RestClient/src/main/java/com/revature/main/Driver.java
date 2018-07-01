package com.revature.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Pokemon;

public class Driver {
	
	private static final Logger log = LoggerFactory.getLogger(Driver.class);
	
	public static void main(String[] args) {
		
		//RestTemplate is an object provided by Spring Web module which allows us to map resources from a REST service to java objects
		RestTemplate restTemplate = new RestTemplate();
		
		String getRequestUrl = "http://localhost:8084/pokemon/1325";
		
		try {
			//we can use its getForObject method to perform a get request for a resource
	    	//the class we want the resource to be mapped to, as well as the URL of the resource must be provided
			Pokemon p = restTemplate.getForObject(getRequestUrl, Pokemon.class);
			log.info("Resource consumption successful");
			log.info(p.toString());
		}catch(Exception e) {
			log.error("Resource consumption unsuccessful");
		}
		
		String postRequestUrl = "http://localhost:8084/pokemon";
		Pokemon newP = new Pokemon(3, "Bulbasaur", "Grass", "First");
		
		try {
			//we can use the RestTemplate's postForObject method to perform a post request for a resource
	    	//we again have to provide the class and URL, along with the object we want to add
			Pokemon addedPokemon = restTemplate.postForObject(postRequestUrl, newP, Pokemon.class);
			log.info("Resource consumption successful");
			log.info("Posted : " + addedPokemon.toString());
		}catch(Exception e) {
			log.error("Resource Consumption Unsuccessful");
		}
	}

}
