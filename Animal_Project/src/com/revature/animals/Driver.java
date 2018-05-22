package com.revature.animals;


import com.revature.movement.Movement;

//Driver class, creates a hawk, moves it, then creates a baby hawk.
public class Driver {

	public static void main(String[] args) {
		Animals hawk = new Hawk();
		//Moves east 12, south 4, up 70
		Movement movement = new Movement(12, -4,70);
		hawk.move(movement);
		hawk.reproduce();

	}

}
