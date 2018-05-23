package com.revature.animalkingdom;

//Cat represents inheritance by extending the animal class
public class Cat extends Animal implements Moving 
{
	//Default constructor for a cat using the animal's constructor to assign various attributes
	public Cat()
	{
		super("walk", "white", "meow", 4);
	}
	
	//A cat constructor for if the user only knows the color of the cat.
	public Cat(String color)
	{
		super(color);
		this.setMovementType("Walk");
		this.setNumOfLegs(4);
		this.setSound("meow");
	}
	
	//A cat constructor assigning all attributes user specified attributes with input validation on the movement type
	public Cat(String color, String movementType, int numOfLegs)
	{
		super(color);
		
		//The only types of movements permittable by a cat is walk and swim. A cat cannot fly!
		if(!(movementType.equalsIgnoreCase("Walk") || movementType.equalsIgnoreCase("Swim")))
		{
			try
			{
				throw new MovementTypeException("A cat cannot " + movementType);
			}
			catch(MovementTypeException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			this.setMovementType(movementType);
			this.setNumOfLegs(numOfLegs);
			this.setSound("meow");
		}
	}
	//The implementation of move specific to a cat.
	void move()
	{
		System.out.println("The cat is able to " + this.getMovementType());
	}
}
