package com.revature.beans;

public class Car {
	// on the client side, I need an object to correspond with the resource we plan to consume from our REST Service
	
	int vin;
	String make;
	String model;
	int year;

	public Car() {
		super();
	}

	public Car(int vin, String make, String model, int year) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + "]";
	}

}
