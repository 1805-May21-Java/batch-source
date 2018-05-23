package com.revature.animals;

import com.revature.animals.exceptions.TrickException;

public class Canine extends Animal{
//	The Canine class has an array variable tricks
//	Each Canine has a max number of tricks that it can learn
	private String[] tricks;
	
//	Constructor to allow for a generic way to initalize a new Canine
	public Canine() {
		super();
		food="Meat";
		sound="Woof";
		numOfLegs=4;
		tricks=new String[1];
	}

//	Overloading the constuctor to allow for a more detailed way to initalize a new Canine
//	Makes use of polymorphism
	public Canine(String food, String sound, int numOfLegs, int numOfTricks) {
		this.food=food;
		this.sound=sound;
		this.numOfLegs=numOfLegs;
		tricks=new String[numOfTricks];
	}

// Overriding the abstract moveAnimal method from the Animal class so as to add behavior
// Makes use of polymorphism
	@Override
	public void moveAnimal() {
		System.out.println("The Dog is walking.");
	}

//	Setter for setting the number of tricks that a Canine can preform
	public void setNumOfTricks(int numOfTricks) {
		tricks=new String[numOfTricks];
	}

// 	Prints out the tricks that a Canine can preform
	public void printTricks() {
		for(String trick:tricks) {
			if(trick==null) {
				break;
			}
			else
				System.out.println(trick);
		}
	}
//	Method for adding a trick into the tricks variable
	public void teachNewTrick(String newTrick) {
	//	Assumes that there is no room for anymore tricks
		boolean hasRoom=false;
	//	Loops through the array to check if there are any free spaces
	// 	If there are, it sets that space to the new trick
		for(int i=0;i<tricks.length;i++) {
			if(tricks[i]==null) {
				hasRoom=true;
				tricks[i]=newTrick;
				break;
			}
		}
	//	If there is no room for anymore tricks, exception is thrown 
		if(!hasRoom) {
			try {
				throw new TrickException("Canine cannot learn anymore tricks");
			}
			catch(TrickException e){
				e.printStackTrace();
			}
		}
	}
}
