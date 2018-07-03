package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.LibraryFullException;
import com.revature.model.Book;
import com.revature.model.Hero;

@WebService
public interface Library { // this is our Service Endpoint Interface (SEI)

	public List<Hero> getAllHeroes();
	public String addHero(Hero hero) throws LibraryFullException;
	
}
