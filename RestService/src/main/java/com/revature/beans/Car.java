package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Component
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Car {
	
	@Id
	@Column
	int vin;
	
	@Column
	String make;
	
	@Column
	String model;
	
	@Column
	@Digits(fraction = 0, integer = 4)
	int year;

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


	@Override
	public String toString() {
		return "Car [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + "]";
	}

}
