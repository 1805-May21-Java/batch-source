package com.Revature.EmployeePkg;

public class Employee {
	//Define employee attributes
	private String name;
	private String department;
	private int age;

	//Default constructors
	public Employee() {
		super();
	}

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//Generic getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
