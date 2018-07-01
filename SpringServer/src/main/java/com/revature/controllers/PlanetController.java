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

import com.revature.beans.Planet;
import com.revature.services.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {
	
	@Autowired
	PlanetService planetService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Planet createPlanet(@RequestBody Planet planet) {
		return planetService.savePlanet(planet);	
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Planet updatePlanet(@RequestBody Planet planet ){
		return planetService.updatePlanet(planet);	
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Planet deletePlanet(@RequestBody Planet planet) {
		return planetService.deletePlanet(planet);	
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Planet getPlanetById(@PathVariable("id") Integer id) {
		return planetService.findPlanetById(id);
	}
	
	@GetMapping( produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Planet> getAllPlanets() {
		return planetService.findAllPlanets();
	}
	
	@RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.TRACE })
	public Planet metadataCar() {
		return null;
	}


}
