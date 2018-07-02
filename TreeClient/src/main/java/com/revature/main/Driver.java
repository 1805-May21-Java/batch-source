package com.revature.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Tree;

public class Driver
{
	private static final Logger log = LoggerFactory.getLogger(Driver.class);
	
	
	public static void main(String[] args)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		String postUrl = "http://jartree-env.7zjqufhvkj.us-east-2.elasticbeanstalk.com/trees";
		String requestUrl = postUrl + "/1";

		try {
			Tree[] trees = restTemplate.getForObject(postUrl, Tree[].class);
			log.info("Resource consumption successful");
			for(Tree tree : trees) {
				log.info("Resource retrieved: " + tree);
			}
		}
		catch(Exception e) {
			log.error("Resource consumption unsuccessful");
		}
		
		try {
			Tree tree = restTemplate.getForObject(requestUrl, Tree.class);
			log.info("Resource consumption successful");
			log.info(tree.toString());
		}
		catch (Exception e) {
			log.error("Resource consumption unsuccessful");
		}
		
		Tree newTree = new Tree(99999, 100, "red", 30);
		try {
			Tree added = restTemplate.postForObject(postUrl, newTree, Tree.class);
			log.info("Resource consumption successful");
			log.info("Posted: " + added.toString());
		}
		catch (Exception e) {
			log.error("Resource production unsuccessful");
		}
		
		Tree updated = new Tree(99999, 500, "brown", 30);
		try {
			restTemplate.put(postUrl, updated);
			log.info("Resource update successful");
		}
		catch(Exception e) {
			log.error("Resource update unsuccessful");
		}
		
		try {
			restTemplate.delete((postUrl + "/99999"));
			log.info("Resource successfully deleted");
		}
		catch (Exception e) {
			log.error("Resource was not successfully removed");
		}
	}

}
