package com.revature.beans;

import com.revature.exceptions.NegativeSpeedException;

public class Bicycle extends Vehicle {

	private final int numOfWheels = 2;
	private boolean hasKickstand;
	
	public Bicycle() {
		super();
	}
	public boolean isHasKickstand() {
		return hasKickstand;
	}
	public void setHasKickstand(boolean hasKickstand) {
		this.hasKickstand = hasKickstand;
	}
	public Bicycle(int maxSpeed, int weightCapacity, int currentSpeed, boolean isOperating) {
		super(maxSpeed, weightCapacity, currentSpeed, isOperating);
		// TODO Auto-generated constructor stub
	}
	
	public void speedUp(int increment) {
		
		this.currentSpeed = this.currentSpeed + increment;
		System.out.println("Bicycle has increased speed by " + increment);
		System.out.println("Current vehicle speed id " + this.currentSpeed);

	}

	public void slowDown(int decrement) {
		
		if(this.currentSpeed - decrement < 0) {
			try {
				throw new NegativeSpeedException("Bicycle can not have a speed less than 0");
			} catch (NegativeSpeedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.currentSpeed = this.currentSpeed - decrement;
		System.out.println("Bicycle has decreased speed by " + decrement);
		System.out.println("Current vehicle speed id " + this.currentSpeed);

	}
	
	public static void staticMethod() {
		System.out.println("Declaring vehicle object as a bicycle");

		
	}
	
}
