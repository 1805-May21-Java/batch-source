package com.revature.beans;

public class Submarine extends Vehicle{

	private int depth;
	private boolean periscopeExtended;
	private int numOfTorpedos;
	private boolean redAlert;
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public boolean isPeriscopeExtended() {
		return periscopeExtended;
	}
	public void setPeriscopeExtended(boolean periscopeExtended) {
		this.periscopeExtended = periscopeExtended;
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
	public Submarine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Submarine(int maxSpeed, int weightCapacity, int currentSpeed, boolean isOperating) {
		super(maxSpeed, weightCapacity, currentSpeed, isOperating);
		// TODO Auto-generated constructor stub
		this.maxSpeed = maxSpeed;
		this.weightCapacity = weightCapacity;
		this.currentSpeed = currentSpeed;
		this.isOperating = isOperating;
	}
	
	public static void staticMethod() {
		System.out.println("Declaring vehicle object as a submarine");

		
	}
	
}
