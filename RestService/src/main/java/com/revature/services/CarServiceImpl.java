package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Car;
import com.revature.repositories.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepository carRepo;
	
	@Override
	public Car findCarById(int id) {
		return carRepo.getOne(id);
	}

	@Override
	public List<Car> findAllCars() {
		return carRepo.findAll();
	}

	@Override
	public Car createCar(Car car) {
		return carRepo.save(car);
	}

	@Override
	public Car updateCar(Car car) {
		return carRepo.save(car);
	}

	@Override
	public Car deleteCar(Car car) {
		carRepo.delete(car);
		return car;
	}

}
