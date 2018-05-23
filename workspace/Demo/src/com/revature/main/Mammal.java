package com.revature.main;



/**
 * @author vannarahouth
 * We use abstract class Mammal to define Animal makeNoise()
 * 
 *
 */
public abstract class Mammal implements Animal {
	protected String type = "Mammal";
	
	@Override
	public void makeNoise() {
		System.out.println("huh huh");
		
	}
	
}
