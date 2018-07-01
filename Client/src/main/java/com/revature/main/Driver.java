package com.revature.main;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.Game;

public class Driver {
	
	private static final Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		
		RestTemplate restTemp = new RestTemplate();
		
		String all = "http://restservice-env.p2gm9auddp.us-east-2.elasticbeanstalk.com/games";
		String one = "http://restservice-env.p2gm9auddp.us-east-2.elasticbeanstalk.com/games/1";
		
		//Get all of the resources
		Game[] games = restTemp.getForObject(all, Game[].class);
		System.out.println();
		System.out.println("Here are all the games:");
		for(Game game : games) {
			System.out.println("\t"+game);
		}
		System.out.println();
		
		//Get a single resource
		Game game = restTemp.getForObject(one, Game.class);
		System.out.println();
		System.out.println("Here is the game with id 1:");
		System.out.println(game);
		System.out.println();

		//Post a new resource
		game = new Game(3, "Assassins Creed 4: Black Sails", "RPG", 2013);
		System.out.println("Here is the game i'm going to post");
		System.out.println("\t"+game);
		System.out.println();
		
		restTemp.postForObject(all, game, Game.class);
		
		//Make sure that the Post was successful
		games = restTemp.getForObject(all, Game[].class);
		System.out.println();
		System.out.println("Here are all the games after the post:");
		for(Game oneGame : games) {
			System.out.println("\t"+oneGame);
		}
		System.out.println();
		
		//Put a new resource
		System.out.println();
		System.out.println("Wait, its supposed to be Assassins Creed IV, not Assassins Creed 4");
		System.out.println("Let's change that with a put request");
		System.out.println();
		
		game.setTitle("Assassins Creed IV: Black Flag");
		restTemp.put(all, game);
		
		//Make sure that the Put was successful
		games=restTemp.getForObject(all, Game[].class);
		System.out.println();
		System.out.println("Here are all the games after the put:");
		for(Game oneGame : games) {
			System.out.println("\t"+oneGame);
		}
		System.out.println();
		
		//Delete a new resource
		System.out.println();
		System.out.println("Acctually, I don't want Assassins Creed anymore, I'm going to delete it");
		System.out.println();
		
		String three = "http://restservice-env.p2gm9auddp.us-east-2.elasticbeanstalk.com/games/3";
		
		try {
			restTemp.delete(new URI(three));
			
			//Make sure that the Delete was successful
			games=restTemp.getForObject(all, Game[].class);
			System.out.println();
			System.out.println("Here are all the games after the delete:");
			for(Game oneGame : games) {
				System.out.println("\t"+oneGame);
			}
			System.out.println();
			
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
