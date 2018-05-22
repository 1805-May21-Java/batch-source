package Animalpkg;

import animalExceptions.negativeLegs;

//Defines a public class animal that can Move
public class Animal implements Moveable {
	protected int numLegs; //All animals have a number of legs greater than or equal to zero
	
	Animal() {
		super();
	}
	
	Animal( int numLegs ) {
		this.numLegs = numLegs;
	}
	
	public int getNumLegs() {
		return numLegs;
	}

	public void setNumLegs(int numLegs) throws negativeLegs { 
		//Able to throw a negative number of legs exception
		if ( numLegs < 0 ) {
			throw new negativeLegs("Animals cannot have negative legs");
		}
		
		//If numLegs is not negative, allow legs to be set
		this.numLegs = numLegs;
	}

	public void move() { //Implements Move method from Moveable interface
		//Abstracts away from how Animals move
		//Just defines that they do move
		System.out.println("Generic animal waddle");
	}
}
