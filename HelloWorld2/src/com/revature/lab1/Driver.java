package com.revature.lab1;

public class Driver {

	public Driver() {
		
		super();
	}

	public static void main(String[] args) {

		Animal a1 = new Cow();
		Animal a2 = new Bee();
		Animal a3 = new Goat();
		Animal a4 = new Horse();
		
		a1.sound();
		a2.sound();
		a3.sound();
		a4.sound();
		
		try {
			a1.setWeight(-1);
		}
		catch(AnimalException e) {
			e.printStackTrace();

		}
	}

}
