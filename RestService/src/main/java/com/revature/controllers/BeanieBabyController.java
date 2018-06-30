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

import com.revature.beans.BeanieBaby;
import com.revature.services.BeanieBabyService;

@RestController
@RequestMapping("/beanie-babies")
public class BeanieBabyController {
	@Autowired
	BeanieBabyService bbService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<BeanieBaby> getAllBeanieBabies() {
		return bbService.findAllBeanieBabies();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public BeanieBaby getBeanieBabyById(@PathVariable("id") Integer id) {
		return bbService.findBeanieBabiesById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public BeanieBaby createBeanieBaby(@RequestBody BeanieBaby beanieBaby) {
		return bbService.createBeanieBaby(beanieBaby);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public BeanieBaby updateBeanieBaby(@RequestBody BeanieBaby beanieBaby) {
		return bbService.updateBeanieBaby(beanieBaby);
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public BeanieBaby deleteBeanieBaby(@RequestBody BeanieBaby beanieBaby) {
		bbService.deleteBeanieBaby(beanieBaby);
		return beanieBaby;
	}
	
	@RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.TRACE })
	public BeanieBaby metadataCar() {
		return null;
	}
}
