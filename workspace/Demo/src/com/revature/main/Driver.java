package com.revature.main;

import java.util.ArrayList;

import com.revature.expections.NegativeAgeException;


/**
 * @author vannarahouth
 *This is the demo class where we put try and catch block if the age of the dog is negative.
 *if the age of the dog is negative we catch it and display message
 *
 *This also show the advantages of using Polymorphism for the program too
 *We create Animal arraylist and store all type of animal such as Dog, or Snake.
 */
public class Driver {

	
	
	public static void main(String[] args) {
		
		try{
			ArrayList<Animal> animals = new ArrayList<>();
			Animal dog = new Dog(4);
			Animal snake= new Snake(3);
			
			animals.add(dog);
			animals.add(snake);
			for(Animal animal: animals)
			{
				System.out.print(animal.animalName()+" Makes Sound: ");
				animal.makeNoise();
				System.out.println(animal.animalName()+" Can Move: "+animal.speed()+" mi/hr");
				System.out.println();		
			}
			
		}
		catch(NegativeAgeException e){
			System.out.println(e.toString());
		}
		

	}

}
