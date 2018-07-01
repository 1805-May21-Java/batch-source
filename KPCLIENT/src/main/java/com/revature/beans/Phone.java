package com.revature.beans;

public class Phone {

	int PhoneId;
	String Brand;
	String Name;
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