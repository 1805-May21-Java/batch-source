package com.revature.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.revature.data.Hero;

public interface HeroInterface {
	Hero createHero(Hero hero);
	Hero findHeroById(long id);
	Hero findHeroByName(String name);
	List<Hero> getAllHeroes();
}
