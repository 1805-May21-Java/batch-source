package com.revature.services;

import java.util.List;

import com.revature.beans.Planet;

public interface PlanetService {
	
	public Planet savePlanet(Planet planet);
	public Planet updatePlanet(Planet planet);
	public Planet deletePlanet(Planet planet);
	public Planet findPlanetById(int id);
	public List<Planet> findAllPlanets();

}
