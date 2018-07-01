package com.revature.htulipan.RestServer.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phone {
	
	@Id
	@Column
	int phoneId;
	
	@Column
	String brand;
	
	@Column
	String name;
	
	@Column
	@Digits(fraction = 0, integer = 4)
	String year;

	public Phone() {
		super();
	}

	public Phone(int phoneId, String brand, String name, @Digits(fraction = 0, integer = 4) String year) {
		super();
		this.phoneId = phoneId;
		this.brand = brand;
		this.name = name;
		this.year = year;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", brand=" + brand + ", name=" + name + ", year=" + year + "]";
	}
	
}
