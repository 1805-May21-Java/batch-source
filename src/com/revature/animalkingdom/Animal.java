package com.revature.animalkingdom;

/*
 * Inheritance is shown by having Dog, Cat, Fish, and Bird inherit from the animal class
 */
public class Animal implements Moving
{
	private String movementType, color, sound;
	private int numOfLegs;

	//Default constructor using the super classes constructor
	public Animal()
	{
		super();
	}
	
	//Animal constructor for if the user only knows the color of the animal 
	public Animal(String color) 
	{
		super();
		this.setColor(color);
	}
	
	//An animal constructor using all attributes of animal
	public Animal(String movementType, String color, String sound, int numOfLegs)
	{
		super();
		this.movementType = movementType;
		this.color = color;
		this.sound = sound;
		this.numOfLegs = numOfLegs;
	}
	
	//Getters and Setters for all animal attributes
	public String getColor() 
	{
		return color;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}

	public int getNumOfLegs() 
	{
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) 
	{
		this.numOfLegs = numOfLegs;
	}

	public String getMovementType() 
	{
		return movementType;
	}

	public void setMovementType(String movementType) 
	{
		this.movementType = movementType;
	}
	
	/************By using private variables, getters, and setters I demonstrate encapsulation.***********/
	
	public String getSound()
	{
		return sound;
	}

	public void setSound(String sound)
	{
		this.sound = sound;
	}
	
	//The implementation of move for an animal
	void move()
	{
		System.out.println("The Animal is moving.");
	}
	
	
}
