package oop;

// Abstraction implements an interface:
public class Animal implements BasicInfoInterface {

	// Encapsulation uses private instance variables:
	private String name;
	private int age;
	
	// Polymorphism uses the same constructor in different ways:
	public Animal() {
		super();
	}
	
	// Encapsulation uses setter methods:
	public Animal(String name, int age) {
		this.setName(name);
		try {
			this.setAge(age);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "Name: " + getName() + ", Age: " + getAge();
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	// Encapsulation uses setters to validate changes:
	@Override
	public void setAge(int years) throws Exception {
		if (years >= 0) {
			this.age = years;
		} else {
			throw new Exception("Age must be a positive value");
		}
	}
	
	@Override
	public int getAge() {
		return this.age;
	}
	
}
