package com.revature.assignment;
//Dog, Cat, and Duck do inheritance, as they inherit from Animal
public class Wolf extends Animal{ //child of Animal
	private int speed;
	@Override //polymorphism
	public void sound() { // concrete method with a body
		System.out.println("Woof");
	}
	public static void main(String args[]) {
		Animal obj = new Wolf(); //creating new Wolf from Animal
		obj.sound();
	}
	public void setSpeed(int speed) throws NegativeSpeedException{
		if (speed < 0)
			throw new NegativeSpeedException("Exception thrown: No negative speed");
		else
			this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
}
