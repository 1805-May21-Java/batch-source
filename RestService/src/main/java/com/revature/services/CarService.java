package com.revature.services;

import java.util.List;

import com.revature.beans.Car;

public interface CarService {
	
	public Car findCarById(int id);
	public List<Car> findAllCars();
	public Car createCar(Car car);
	public Car updateCar(Car car);
	public Car deleteCar(Car car);

}
