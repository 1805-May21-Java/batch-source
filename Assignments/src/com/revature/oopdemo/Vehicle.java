package com.revature.oopdemo;

// Interface for Objects that can be ridden

public interface Vehicle {
	int NUM_LEGS = 4;
	
	void speedUp(int incremement);
	void slowDown(int increment);
	
	int getCurrentSpeed();
	int getMaxSpeed();
	void setMaxSpeed(int maxSpeed);
	
}
