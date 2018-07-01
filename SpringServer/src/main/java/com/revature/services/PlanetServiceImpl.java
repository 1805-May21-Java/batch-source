package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Planet;
import com.revature.repositories.PlanetRepository;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {
	
	@Autowired
	PlanetRepository planetRepo;

	@Override
	public Planet savePlanet(Planet planet) {
		return planetRepo.save(planet);
	}

	@Override
	public Planet updatePlanet(Planet planet) {
		return planetRepo.save(planet);
	}

	@Override
	public Planet deletePlanet(Planet planet) {
		planetRepo.delete(planet);
		return planet;
	}

	@Override
	public Planet findPlanetById(int id) {
		return planetRepo.getOne(id);
	}

	@Override
	public List<Planet> findAllPlanets() {
		return planetRepo.findAll();
	}

}
