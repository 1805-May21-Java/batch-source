package pkg;

import animalExceptions.negativeLegs;

public class Animal implements Moveable {
	protected int numLegs;
	
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
		if ( numLegs < 0 ) {
			throw new negativeLegs();
		}
		this.numLegs = numLegs;
	}

	public void move() {
		System.out.println("Generic animal waddle");
	}
}
