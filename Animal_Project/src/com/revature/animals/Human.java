package com.revature.animals;


//class for human animals, extends mammals which extends animals
public class Human extends Mammals {

	public Human() {
		super();
	}
	public Human(int gestationTime,float diameterOfHair ) {
		super(gestationTime,diameterOfHair);
	}
	
	
	@Override
	void reproduce() {
		super.reproduce();
		Human baby = new Human();
		
	}

}
