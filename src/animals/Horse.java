package animals;

import com.revature.exception.NegativeSpeedException;

public class Horse extends Mammal{ //Inheritance
	
	//generate constructor and superclass
	public Horse(int speed) {
		super();
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}
	public Horse(int numLegs, int weightinKilo, int heightInCentimeter) {
		super(numLegs, weightinKilo, heightInCentimeter);
		this.numLegs = 4;
		this.weightinKilo = 500;
		this.heightInCentimeter = 157;
	}
	
	//concrete methods coming from Animal class
	public void makeNoise() {
		System.out.println("Neighhh");
	}
	public void lifeExpectancy() {
		System.out.println("25 to 30 years." );
	}
	
	private double speed;
	
	//Encapsulation, getter and setter method
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	//Horse Functions, int and double are for overload polymorphism
	public void speedUp(int increment) {
		this.speed += increment;
		System.out.println("Horse has increased speed by " + increment);
		System.out.println("Horse speed is " + this.speed);
	}
	public void speedUp(double increment) {
		this.speed += increment;
		System.out.println("Horse has increased speed by " + increment);
		System.out.println("Horse speed is " + this.speed);
	}
	
	// Similar to speedUp
	public void slowDown(int decrement) {
		this.speed -= decrement;
		if (this.speed < 0) {
			throw new NegativeSpeedException("Horse can not run negative speed!");
		}
		System.out.println("Horse has decreased speed by " + decrement);
		System.out.println("Horse speed is " + this.speed);
	}
	public void slowDown(double decrement) {
		this.speed -= decrement;
		if (this.speed < 0) {
			// has a user created Exception from runtime that doesn't allow negative speed
			throw new NegativeSpeedException("Horse can not run negative speed!");
		}
		System.out.println("Horse has decreased speed by " + decrement);
		System.out.println("Horse speed is " + this.speed);
	}
	
	//override polymorphism
	public void staticMethod() {
		System.out.println("This is a Horse Method");
	}
	
}
