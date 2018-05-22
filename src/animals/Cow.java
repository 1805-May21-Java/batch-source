package animals;

import com.revature.exception.EmptyMilkException;

public class Cow extends Mammal { //Inheritance
	
	//generate constructor and superclass
	public Cow() {
		super();		
	}
	
	public Cow(int numLegs, int weightinKilo, int heightInCentimeter) {
		super(numLegs, weightinKilo, heightInCentimeter);
		this.numLegs = 4;
		this.weightinKilo = 753;
		this.heightInCentimeter = 117;
	}

	//concrete methods coming from Animal class
	public void makeNoise() {
		System.out.println("Moooooo");
	}
	public void lifeExpectancy() {
		System.out.println("18 to 22 years." );
	}
	
	private final int milkPerDay = 2;
	private int currentMilk = milkPerDay;
	
	//Encapsulation, getter and setter method
	public int getCurrentMilk() {
		return currentMilk;
	}
	public void setCurrentMilk(int currentMilk) {
		this.currentMilk = currentMilk;
	}

	//doesn't need a setter for final variables
	public int getMilkPerDay() {
		return milkPerDay;
	}
	
	//Cow functions
	public void milkCow(int decrement) {
		currentMilk -= decrement;
		if(currentMilk < 0) {
			//has a user created Exception from runtime that doesn't allow negative milk contained
			throw new EmptyMilkException("You can not milk an empty cow!");
		}
		System.out.println("This cow has been milked: " + (milkPerDay - currentMilk) + " times.");
	}
	
	//override polymorphism
	public void staticMethod() {
		System.out.println("This is a Cow Method");
	}
}
