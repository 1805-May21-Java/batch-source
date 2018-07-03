package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.LibraryFullException;
import com.revature.model.Hero;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library { // this is our Service Implementing Bean (SIB)

	@Override
	public List<Hero> getAllHeroes() {
		List<Hero> heroList = new ArrayList<>();
		heroList.add(new Hero("antimage", 1, "Anti-mage"));
		heroList.add(new Hero("axe", 2, "Axe"));
		heroList.add(new Hero("bane", 3, "Bane"));
		return heroList;
	}

	@Override
	public String addHero(Hero hero) throws LibraryFullException {
		if(hero.getName().equals("Techies")) {
			throw new LibraryFullException("Hero is banned. Cannot add "+hero.getName());
		}
		return "successfully added " + hero.getName();
	}

}
