package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Lot {
	
	@Id
	@Column
	int lotId;
	
	@Column
	String street;
	
	@Column
	String city;
	
	@Column
	String state;
	
	@OneToMany(mappedBy="lot")
	List<Car> cars;

	public Lot(int lotId, String street, String city, String state, List<Car> cars) {
		super();
		this.lotId = lotId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.cars = cars;
	}

	public Lot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLotId() {
		return lotId;
	}

	public void setLotId(int lotId) {
		this.lotId = lotId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	
	
}
