package com.revature.oop;

/* INHERITANCE - superclass of Mammal is Animal.
 * Mammal adopts the states and behavior of Animal.
 */
public class Mammal extends Animal implements NonMonotreme{
	
	//private final boolean hasLiveYoung = true; // cannot be changed (not technically true, because platypus)
	private boolean canSwim;
	
	
	public Mammal(boolean canSwim) {
		super(); // inherits from superclass
		this.canSwim = canSwim;
	}

	/* ENCAPSULATION - public getters and setters are used outside of the class
	 * for modifying internal class variables.
	 */
	public boolean isCanSwim() {
		return canSwim;
	}

	public void setCanFly(boolean canSwim) {
		this.canSwim = canSwim;
	}


	public boolean isHasLiveYoung() {
		return hasLiveYoung;
	}
	
	
	
	

}
