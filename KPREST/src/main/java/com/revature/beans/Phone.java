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
public class Phone {
	@Id
	@Column
	int PhoneId;
	
	@Column
	String Brand;
	
	@Column
	String Name;
	
	@Column
	@Digits(fraction = 0, integer = 4)
	int year;

	public int getPhoneId() {
		return PhoneId;
	}

	public void setPhoneId(int phoneId) {
		PhoneId = phoneId;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Phone(int phoneId, String brand, String name, int year) {
		super();
		PhoneId = phoneId;
		Brand = brand;
		Name = name;
		this.year = year;
	}
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Phone [PhoneId=" + PhoneId + ", Brand=" + Brand + ", Name=" + Name + ", year=" + year + "]";
	}	
}
