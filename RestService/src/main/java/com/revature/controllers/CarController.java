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

@RestController // takes the place of @Controller and @ResponseBody on each of the methods
@RequestMapping("/cars") // maps every request in this class
public class CarController {
	
	@Autowired
	CarService carService;
		
	//http verbs are mapped according to their role - all CRUD operations included
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getAllCars() {
		return carService.findAllCars();
	}	

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Car getCarById(@PathVariable("id") Integer id) {
		return carService.findCarById(id);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Car createCar(@RequestBody Car car) {
		return carService.createCar(car);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Car updateCar(@RequestBody Car car) {
		return carService.updateCar(car);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Car deleteCar(@RequestBody Car car) {
		carService.deleteCar(car);
		return car;
	}
	
	//although no meaningful behavior associated with them, methods outside of those implementing CRUD functionality included as well
	@RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.TRACE })
	public Car metadataCar() {
		return null;
	}

}
