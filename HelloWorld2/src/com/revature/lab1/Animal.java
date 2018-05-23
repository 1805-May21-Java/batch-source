package com.revature.lab1;
import java.util.Random;

import com.revature.exceptions.NegativeSpeedException;

abstract public class Animal {

	protected int numLegs;
	protected int weight;
	
	public int getNumLegs() {
		return numLegs;
	}

	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) throws AnimalException {
		if(weight < 0) {
			try {
				throw new AnimalException("Can not have a negative weight");
			} catch (AnimalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			this.weight = weight;			
		}
		
	}	
	
	public Animal() {
		super();
	
	}
	
	public int walk() {
		
		Random rand = new Random();

		return rand.nextInt(5);
		 
	}
	
	public abstract void sound();
	

}
