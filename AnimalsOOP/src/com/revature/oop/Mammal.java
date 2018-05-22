package com.revature.oop;

public class Mammal extends Animal {
	
	private final boolean hasLiveYoung = true;
	private boolean canSwim;
	
	
	public Mammal(boolean canSwim) {
		super();
		this.canSwim = canSwim;
	}

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
