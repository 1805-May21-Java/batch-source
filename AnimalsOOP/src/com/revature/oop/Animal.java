package com.revature.oop;

import com.revature.exceptions.NegativeLegsException;

public class Animal {
	
	protected int numLegs;
	public String name;
	protected boolean canFly;
	
	public Animal() {
		super();
	}
	
	public Animal(String name, int numLegs, boolean canFly) {
		this.name = name;
		this.numLegs = numLegs;
		this.canFly = canFly;
	}
	
	/* ENCAPSULATION - public getters and setters are used outside of the class
	 * for modify internal class variables.
	 */
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	// Predator attack means that animal loses a limb/leg. Sorry.
	public void predatorAttack() {
		if (this.numLegs - 1 < 0) {
			// catch exception for negative number of limbs
			try {
				throw new NegativeLegsException("Animal cannot have a NEGATIVE number of limbs! That would be...weird, to say the least.");
			} catch (NegativeLegsException e) {
				e.printStackTrace();
			}
		} else {
			this.numLegs--;
		}
	}

	
	

}
