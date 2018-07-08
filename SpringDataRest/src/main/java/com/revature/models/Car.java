package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Car {
	
	@Id
	@Column
	int vin;
	
	@Column
	String make;
	
	@Column 
	String model;
	
	@Column
	@Digits(fraction=0, integer=4)
	int year;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="lotId")
	Lot lot;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int vin, String make, String model, @Digits(fraction = 0, integer = 4) int year) {
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

	
	
	
	
}
