package com.revature.beans;

import com.revature.exceptions.NegativeSpeedException;

public class Bicycle extends Vehicle {
	
	private final int numOfWheels = 2;
	private boolean hasKickstand;
	
	public Bicycle() {
		super();
	}
	
	public Bicycle(int maxSpeed, int weightCapacity, int currentSpeed, boolean isOperating) {
		super(maxSpeed, weightCapacity, currentSpeed, isOperating);
	}
	
	public Bicycle(boolean hasKickstand) {
		super();
		this.hasKickstand = hasKickstand;
	}

	public boolean isHasKickstand() {
		return hasKickstand;
	}
	
	public void setHasKickstand(boolean hasKickstand) {
		this.hasKickstand = hasKickstand;
	}
	
	public int getNumOfWheels() {
		return numOfWheels;
	}
	
	public void speedUp(int increment) {
		//this.currentSpeed = this.currentSpeed + increment;
		this.currentSpeed += increment;
		System.out.println("Bicycle has increased speed by "+increment);
		System.out.println("Current bicycle speed is "+this.currentSpeed);
	}
	
	public void slowDown(int decrement) {
		//this.currentSpeed = this.currentSpeed + decrement;
		if (this.currentSpeed - decrement < 0) {
			try {
				throw new NegativeSpeedException("Bicycle cannot have a speed less than 0");
			} catch (NegativeSpeedException e) {
				e.printStackTrace();
			}
		} else {
			this.currentSpeed -= decrement;
			System.out.println("Bicycle has decreased speed by "+decrement);
			System.out.println("Current bicycle speed is "+this.currentSpeed);
		}
	}
	
	public static void staticMethod() {
		System.out.println("Static method from bicycle");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasKickstand ? 1231 : 1237);
		result = prime * result + numOfWheels;
		return result;
	}

	@Override
	public String toString() {
		return "Bicycle [numOfWheels=" + numOfWheels + ", hasKickstand=" + hasKickstand + ", maxSpeed=" + maxSpeed
				+ ", weightCapacity=" + weightCapacity + ", currentSpeed=" + currentSpeed + ", isOperating="
				+ isOperating + "]";
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Bicycle other = (Bicycle) obj;
//		if (hasKickstand != other.hasKickstand)
//			return false;
//		if (numOfWheels != other.numOfWheels)
//			return false;
//		return true;
//	}

	
	
	
}
