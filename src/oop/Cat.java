package oop;

// Inheritance extends from the super class:
public class Cat extends Animal {

	private String furColor;
	
	// Inheritance uses the super class constructor:
	public Cat() {
		super();
	}
	
	public Cat(String name, int age, String color) {
		super(name, age);
		this.furColor = color;
	}
	
	public void setColor(String color) {
		this.furColor = color;
	}
	
	public String getColor() {
		return this.furColor;
	}
	
	// Polymorphism overrides the super class "toString" method:
	@Override
	public String toString() {
		return super.toString() + ", Fur Color: " + getColor();
	}
	
}
