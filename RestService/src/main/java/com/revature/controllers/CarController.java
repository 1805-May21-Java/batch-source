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

import com.revature.beans.Car;
import com.revature.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	CarService carService;
		
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getAllCars() {
		return carService.findAllCars();
	}	

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Car getCarById(@PathVariable("id") Integer id) {
		return carService.findCarById(id);
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Car createCar(@RequestBody Car car) {
		return carService.createCar(car);
	}

	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Car updateCar(@RequestBody Car car) {
		return carService.updateCar(car);
	}

	@DeleteMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Car deleteCar(@RequestBody Car car) {
		carService.deleteCar(car);
		return car;
	}
	
	@RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.TRACE })
	public Car metadataCar() {
		return null;
	}

}
