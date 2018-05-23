package com.revature.beans;

import com.revature.exceptions.NegativeWeightException;

public class Horse extends Animal{
	
//Attributes specific to Horses
	private int numOfHorseShoes;
	private boolean hasSaddle;
	private int numOfRacesWon;
	
	public Horse() {
		super();
	}

//Horse is Inheriting attributes from its super class Animal
	public Horse(int weight, int height, int age, short name) {
		super(weight, height, age, name);
	}

	public Horse(int numOfHorseShoes, boolean hasSaddle, int numOfRacesWon) {
		super();
		this.numOfHorseShoes = numOfHorseShoes;
		this.hasSaddle = hasSaddle;
		this.numOfRacesWon = numOfRacesWon;
	}

	
//The following getters and setters are an example of Encapsulation. The variables are private
//but the public methods here have access
	public int getNumOfHorseShoes() {
		return numOfHorseShoes;
	}

	public void setNumOfHorseShoes(int numOfHorseShoes) {
		this.numOfHorseShoes = numOfHorseShoes;
	}

	public boolean isHasSaddle() {
		return hasSaddle;
	}

	public void setHasSaddle(boolean hasSaddle) {
		this.hasSaddle = hasSaddle;
	}

	public int getNumOfRacesWon() {
		return numOfRacesWon;
	}

	public void setNumOfRacesWon(int numOfRacesWon) {
		this.numOfRacesWon = numOfRacesWon;
	}
	
	public void weightGain(int increment) {
		this.weight += increment;
		System.out.println("Horse has gained weight by " + increment);
		System.out.println("Horse's current weight is " + this.weight);
	}
	
	public void weightLoss(int decrement) {
		if (this.weight - decrement < 0) {
			try {
				throw new NegativeWeightException("Horse cannot have a weight of less than 0");
			} catch (NegativeWeightException e) {
				e.printStackTrace();
			}
		} else {
			this.weight -= decrement;
			System.out.println("Horse has lost weight by "+decrement);
			System.out.println("Horse's current weight is "+this.weight);
		}
	}

}
