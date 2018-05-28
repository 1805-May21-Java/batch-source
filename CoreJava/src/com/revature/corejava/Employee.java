package com.revature.corejava;

public class Employee {
	
	String name;
	String dpt;
	int age;

	public Employee(String name, String dpt, int age) {
		this.name = name;
		this.dpt = dpt;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dpt=" + dpt + ", age=" + age + "]";
	}
	
	
}
