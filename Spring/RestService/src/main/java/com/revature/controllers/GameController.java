package com.revature.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.beans.Game;
import com.revature.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	GameService gameService;
		
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Game> getAllGames() {
		return gameService.findAllGames();
	} 
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Game getGameById(@PathVariable("id") Integer id) {
		return gameService.findGameById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Game createGame(@RequestBody Game game) {
		return gameService.createGame(game);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Game updateGame(@RequestBody Game game) {
		return gameService.updateGame(game);
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Game deleteGame(@RequestBody Game game) {
		return gameService.deleteGame(game);
	}
}
