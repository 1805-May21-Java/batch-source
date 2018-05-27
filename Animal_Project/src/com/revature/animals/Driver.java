package com.revature.animals;

import com.revature.movement.Movement;

public class Driver {

	public static void main(String[] args) {
		
		//This is an example of covarient typing, a type of polymophism, because the child class 
		//is being typed as the parent class.
		Animals hawk = new Hawk();
		//Moves east 12, south 4, up 70
		Movement movement = new Movement(12, -4,70);
		hawk.move(movement);
		hawk.reproduce();

	}

}
