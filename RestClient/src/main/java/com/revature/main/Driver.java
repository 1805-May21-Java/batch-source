package com.revature.main;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Pokemon;

public class Driver {
	
	private static final Logger log = LoggerFactory.getLogger(Driver.class);
	
	public static void main(String[] args) {
		
		//RestTemplate is an object provided by Spring Web module which allows us to map resources from a REST service to java objects
		RestTemplate restTemplate = new RestTemplate();
		
		String postRequestUrl = "http://localhost:8084/pokemon";
		Pokemon newP = new Pokemon(1325, "Bulbasaur", "Grass", "First");
		Pokemon newP2 = new Pokemon(1234, "Squirtle", "Water", "First");
		
		//Post a new Pokemon
		try {
			//we can use the RestTemplate's postForObject method to perform a post request for a resource
	    	//we again have to provide the class and URL, along with the object we want to add
			Pokemon addedPokemon = restTemplate.postForObject(postRequestUrl, newP, Pokemon.class);
			Pokemon addedPokemon2 = restTemplate.postForObject(postRequestUrl, newP2, Pokemon.class);
			log.info("Resource consumption successful");
			log.info("Posted : " + addedPokemon.toString());
			log.info("Posted : " + addedPokemon2.toString());
		}catch(Exception e) {
			log.error("Resource Consumption Unsuccessful");
		}
		
		String getRequestUrl = "http://localhost:8084/pokemon/1325";
		
		//Get a Pokemon 
		try {
			//we can use its getForObject method to perform a get request for a resource
	    	//the class we want the resource to be mapped to, as well as the URL of the resource must be provided
			Pokemon p = restTemplate.getForObject(getRequestUrl, Pokemon.class);
			log.info("Resource consumption successful");
			log.info(p.toString());
		}catch(Exception e) {
			log.error("Resource consumption unsuccessful");
		}
		
		try {
			
			URI pLink = new URI(getRequestUrl);
			restTemplate.delete(pLink);
			log.info("Resource consumption successful");
			//Cant log in Object that was deleted
		}catch (Exception e) {
			log.error("Resource consumption unsuccessful");
		}
		
		String updateRequestUrl = "http://localhost:8084/pokemon/1234";
		try {
			newP2.setName("Blastoise");
			newP2.setEvolutionStage("Second");
			Pokemon updateP = restTemplate.patchForObject(updateRequestUrl, newP2, Pokemon.class);
			
		}catch(Exception e) {
			
		}
		
		
		
		
	}

}
