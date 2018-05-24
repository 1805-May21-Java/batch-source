package com.revature.animalkingdom;

/*
 * I use a Moving interface to demonstrate how Java accomplished multiple inheritance by having
 * Dog, Cat, Bird, and Fish inherit methods from both the moving interface and the animal class.
 */

public interface Moving
{
	int MOVEMENT_SPEED = 5;
	
	//Default implementation for any object capable of moving such as an animal, vehicle, toy, etc.
	default void Move()
	{
		System.out.println("Something is moving.");
	};
}
