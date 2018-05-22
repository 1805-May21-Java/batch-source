package com.revature.hw1;
//Snake is a child class of Animal; inherits all variables of Animal
public class Snake extends Animal{
	public Snake() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Snake(int numOfLimbs, int weightCap, int speedCap, boolean isMammal) {
		super(numOfLimbs, weightCap, speedCap, isMammal);
		// TODO Auto-generated constructor stub
	}
	//Snake has values that are specific to Snake.
	boolean canClimb;
	boolean heatSensors;
	//Snake has defined a unique makeSound.
	public String makeASound(){
		return "HISS!";
	}
	public boolean canClimb() {
		return canClimb;
	}
	public Snake(boolean canClimb, boolean heatSensors) {
		super();
		this.canClimb = canClimb;
		this.heatSensors = heatSensors;
	}
	public void setCanClimb(boolean canClimb) {
		this.canClimb = canClimb;
	}
	public boolean isHeatSensors() {
		return heatSensors;
	}
	public void setHeatSensors(boolean heatSensors) {
		this.heatSensors = heatSensors;
	}
}
