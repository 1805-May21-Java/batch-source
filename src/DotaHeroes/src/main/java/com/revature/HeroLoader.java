package com.revature;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.HeroService;
import com.revature.data.Hero;

//@Component
public class HeroLoader implements CommandLineRunner {
	
	private HeroService heroDao;
	
	public HeroLoader(HeroService heroDao) {
		this.heroDao = heroDao;
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/revature/raw/heroes.json");
		try {
			Hero[] heroList = objectMapper.readValue(file, Hero[].class);
			System.out.println(heroList.length);
			for(Hero hero : heroList) {
				heroDao.createHero(hero);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
