package com.revature.repositories;

import org.springframework.stereotype.Repository;

import com.revature.beans.Planet;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet,Integer>{

}
