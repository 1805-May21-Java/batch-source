package com.revature.beans;

public class Submarine extends Vehicle {
	int depth;
	boolean hasPeriscope;
	int numOfTorpedos;
	boolean redAlert;
	
	public Submarine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Submarine(int maxSpeed, int weightCapacity, int currentSpeed, boolean isOperating) {
		super(maxSpeed, weightCapacity, currentSpeed, isOperating);
		// TODO Auto-generated constructor stub
	}
	
	public Submarine(int depth, boolean hasPeriscope, int numOfTorpedos, boolean redAlert) {
		super();
		this.depth = depth;
		this.hasPeriscope = hasPeriscope;
		this.numOfTorpedos = numOfTorpedos;
		this.redAlert = redAlert;
	}
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public boolean isHasPeriscope() {
		return hasPeriscope;
	}
	
	public void setHasPeriscope(boolean hasPeriscope) {
		this.hasPeriscope = hasPeriscope;
	}
	
	public int getNumOfTorpedos() {
		return numOfTorpedos;
	}
	
	public void setNumOfTorpedos(int numOfTorpedos) {
		this.numOfTorpedos = numOfTorpedos;
	}
	
	public boolean isRedAlert() {
		return redAlert;
	}
	
	public void setRedAlert(boolean redAlert) {
		this.redAlert = redAlert;
	}
	
	public void Ammunition(int torpedos) {
		this.numOfTorpedos = this.numOfTorpedos + torpedos;
		System.out.println("You currently have: " +torpedos+ " torpdoes left" );
	}
	
	public void shoot(int torpedos) {
		torpedos = torpedos - 1;
		System.out.println("You shot 1 Torpedo");
		Ammunition(torpedos);
	}
	
}
