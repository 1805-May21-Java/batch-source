package com.revature.beans;
import java.lang.reflect.*;
import com.revature.SpeedException.SpeedException;

public class Bicycle extends Vehicle {
	private final int numOfWheels = 2;
	private boolean kickStand;
	public boolean isKickStand() {
		return kickStand;
	}
	public Bicycle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bicycle(int maxSpeed, int weightCapacity, int currentSpeed, boolean isOperating) {
		super(maxSpeed, weightCapacity, currentSpeed, isOperating);
		// TODO Auto-generated constructor stub
	}
	
	public void setKickStand(boolean kickStand) {
		this.kickStand = kickStand;
	}
	
	public int getNumOfWheels() {
		return numOfWheels;
	}
	
	public Bicycle(boolean kickStand) {
		super();
		this.kickStand = kickStand;
	}
	
	@Override
	public void speedUp(int increment) {
		this.currentSpeed = this.currentSpeed + increment;
		System.out.println("Bicycle has increased speed by: " +increment);
		System.out.println("Current Bicycle Speed is " +this.currentSpeed);
	}
	
	@Override
	public void slowDown(int decrement) {
		if(this.currentSpeed - decrement < 0)
			try {
				throw new SpeedException("Bicycle cannot have a spedd less than 0");
			} catch ( SpeedException e) {
				e.printStackTrace();
			}
		
		this.currentSpeed = this.currentSpeed - decrement;
		System.out.println("Bicycle has decreased speed by: " +decrement);
		System.out.println("Current Bicycle Speed is " +this.currentSpeed);
	}
	
	public static void StaticMethod() {
		System.out.println("Static Shock");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (kickStand ? 1231 : 1237);
		result = prime * result + numOfWheels;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicycle other = (Bicycle) obj;
		if (kickStand != other.kickStand)
			return false;
		if (numOfWheels != other.numOfWheels)
			return false;
		return true;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Bicycle [numOfWheels=" + numOfWheels + ", kickStand=" + kickStand + ", maxSpeed=" + maxSpeed
				+ ", weightCapacity=" + weightCapacity + ", currentSpeed=" + currentSpeed + ", isOperating="
				+ isOperating + "]";
	}
	
	
}
