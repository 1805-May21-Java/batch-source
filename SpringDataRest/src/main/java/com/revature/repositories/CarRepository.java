package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.revature.models.Car;

@RestResource(path="cars")
public interface CarRepository extends JpaRepository<Car, Integer> {

}
