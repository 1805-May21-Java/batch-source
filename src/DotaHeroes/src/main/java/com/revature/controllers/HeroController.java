package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.daos.HeroService;
import com.revature.data.Hero;

@RestController
@RequestMapping("/hero")
public class HeroController {
	
	@Autowired
	private HeroService heroDao;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hero> getAllHeroes() {
		return heroDao.getAllHeroes();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hero getHeroById(@PathVariable("id") Integer id) {
		return heroDao.findHeroById(id);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Hero createHero(Hero hero) {
		return heroDao.createHero(hero);
	}

}
