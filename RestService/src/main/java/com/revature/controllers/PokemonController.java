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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Pokemon;
import com.revature.services.PokemonService;

@RestController // takes the place of @Controller and @ResponseBody on each of the methods
@RequestMapping("/pokemon") // maps every request in this class
public class PokemonController {
	
	@Autowired
	PokemonService pokeService;
	
	//http verbs are mapped according to their role - all CRUD operations included
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pokemon> getAllPokemon(){
		return pokeService.findAllPokemon();
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Pokemon getPokemonById(@PathVariable("id") int id) {
		return pokeService.findPokemonById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Pokemon createPokemon(@RequestBody Pokemon p) {
		return pokeService.createPokemon(p);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Pokemon updatePokemon(@RequestBody Pokemon p) {
		return pokeService.updatePokemon(p);
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Pokemon deletePokemon(@RequestBody Pokemon p) {
		return pokeService.deletePokemon(p);
	}
	
	//although no meaningful behavior associated with them, methods outside of those implementing CRUD functionality included as well
	@RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.TRACE })
	public Pokemon metaData() {
		return null;
	}

}
