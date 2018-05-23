package oop;

public class Lynx extends Cat {

	private double weight;
	
	public Lynx() {
		super();
	}
	
	public Lynx(String name, int age, String color, double weight) {
		super(name, age, color);
		this.setWeight(weight);
	}
	
	// Encapsulation uses setters and getters:
	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		}
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Weight: " + getWeight();
	}
	
}
