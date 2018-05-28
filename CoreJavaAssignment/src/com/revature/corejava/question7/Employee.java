package com.revature.corejava.question7;

import java.util.Comparator;

public class Employee{

	// Variables to store an Employee's name, department, and age
	private String name;
	private String department;
	private int age;
	
	// Instantiate the object by calling the super class
	public Employee() {
		super();
	}
	
	// Instantiate the object and set all the variables
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	// Getter to return name
	public String getName() {
		return name;
	}
	
	// Setter to set private variable name to local variable name
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter to return department
	public String getDepartment() {
		return department;
	}
	
	// Setter to set private variable department to local variable department
	public void setDepartment(String department) {
		this.department = department;
	}
	
	// Getter to return age
	public int getAge() {
		return age;
	}
	
	// Setter to set private variable age to local variable age
	public void setAge(int age) {
		this.age = age;
	}
	
	// Override the Object method toString to display all the variables of an Employee when 
	// an Employee object is printed
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
	
	
}
