package com.revature.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.BeanieBaby;

public class Driver {
	private static final Logger log = LoggerFactory.getLogger(Driver.class);
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String getRequestUrl = "http://benie-baby-api.us-east-2.elasticbeanstalk.com/beanie-babies/40634";
		
		try {
			BeanieBaby bb = restTemplate.getForObject(getRequestUrl, BeanieBaby.class);
			log.info("Resource consumption successful");
			log.info(bb.toString());
		} catch (Exception e) {
			log.error("Resource consumption unsuccessful");
		}
		
		String postRequestUrl = "http://benie-baby-api.us-east-2.elasticbeanstalk.com/beanie-babies";
		BeanieBaby newBB = new BeanieBaby(40195, "Winksy", "Rabbit", 2004); // try (42106, "Tundra", "White Tiger", 2014) to add something new
		
		try {
			BeanieBaby addedBB = restTemplate.postForObject(postRequestUrl, newBB, BeanieBaby.class);
			log.info("Resource consumption successful");
	        log.info("'Posted':" + addedBB.toString());
		} catch (Exception e) {
			log.error("Resource production unsuccessful");
		}
	}

}
