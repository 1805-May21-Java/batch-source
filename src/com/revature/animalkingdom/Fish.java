package com.revature.animalkingdom;

//Fish represents inheritance by extending the animal class
public class Fish extends Animal implements Moving 
{

	//Default constructor for a fish using the animal's constructor to assign various attributes
	public Fish()
	{
		super("walk", "blue", "bloop bloop", 0);
	}
	
	//A fish constructor for if the user only knows the color of the fish.
	public Fish(String color)
	{
		super(color);
		this.setMovementType("swim");
		this.setNumOfLegs(0);
		this.setSound("bloop bloop");
	}
	
	//A fish constructor assigning all attributes user specified attributes with input validation on the movement type
	public Fish(String color, String movementType)
	{
		super(color);
		
		//The only types of movements permittable by a fish is swim. Fish cannot fly or walk!
		if((movementType.equalsIgnoreCase("Walk") || movementType.equalsIgnoreCase("fly")))
		{
			try
			{
				throw new MovementTypeException("A fish cannot " + movementType);
			}
			catch(MovementTypeException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			this.setMovementType(movementType);
			this.setSound("bloop bloop");
		}
	}
	//The implementation of move specific to a fish.
	void move()
	{
		System.out.println("The fish is able to " + this.getMovementType());
	}

}
