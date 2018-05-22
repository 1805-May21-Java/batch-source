package com.revature.animals;

import com.revature.exceptions.AnimalsAlreadyDead;
import com.revature.movement.Movement;
import com.revature.movement.Position;

//Contains all states and behaviors all animals should have
//Shows abstraction because none of the other classes need to know how to move, just that you can set a move
//Shows encapsulation because all behaviors and states are contained within either this animal class, or the 
//specific child classes
public abstract class Animals {
		
		Position position;
		boolean isAlive = true;
		boolean eatsPlants;
		boolean eatsAnimals;
		
		public Animals() {
			super();
		}
		
		//takes in a movement and returns a new position, throws exception if animal already dead
		public Position move(Movement movement) {
			 try {
				 if(!isAlive) {
					 	throw new AnimalsAlreadyDead("Cannot move if animal is already dead!");
				 }else {
					position.changeX(movement.getMoveEastWest());
					position.changeY(movement.getMoveNorthSouth());
					position.changeZ(movement.getMoveUpDown());
					return position;
				}
			 } catch (AnimalsAlreadyDead e) {
				e.printStackTrace();
				return null;
			}
		}
		
		//Checks if the animal is alive, if not then throws an error
		//Creation of child left to child classes
		//This shows polymorphism because the same reproduce can be called on an animal in general,
		//and it will have different behavior for each child class
		void reproduce() {
				 try {
					 if(!isAlive) {
						 	throw new AnimalsAlreadyDead("Cannot reproduce if animal is already dead!");
					 }
				} catch (AnimalsAlreadyDead e) {
					e.printStackTrace();
				}
		 }
		
		
		//kills the animal
		 public void die() {
			 isAlive = false;
		 };
}
