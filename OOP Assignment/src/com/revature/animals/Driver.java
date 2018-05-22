package com.revature.animals;


public class Driver {

	public static void main(String[] args) {
		Horse horse1 = new Horse();
		Horse deadHorse = new Horse();
		deadHorse.killAnimal();
		Birds[] someBirds = new Birds[5];
		Fish fishy = new Fish();
		Goose goose = new Goose();
		
		someBirds[0] = new Goose();//Polymorphism - Covarient Types - Creating an array of birds with sub-classes
		someBirds[1] = new Macaw();
		someBirds[2] = new Birds();
		someBirds[3] = new Goose();
		someBirds[4] = new Macaw();
		
		for(Birds b: someBirds) {
			b.makeNoise(); //Polymorphism - calls the sub-classes makeNoise() method instead of the super-calsses
		}
		deadHorse.beat();
		
		horse1.move(5, 3);
		horse1.beat();
		horse1.beat();
		horse1.beat();
		
		fishy.makeNoise();
		goose.makeAngryNoise();
		
	}

}
