package com.revature.animalkingdom;

//Dog represents inheritance by extending the animal class
public class Dog extends Animal implements Moving 
{
	
	//Default constructor for a dog using the animal's constructor to assign various attributes
	public Dog()
	{
		super("walk", "brown", "Woof", 4);
	}
	
	//A dog constructor for if the user only knows the color of the dog.
	public Dog(String color)
	{
		super(color);
		this.setMovementType("Walk");
		this.setNumOfLegs(4);
		this.setSound("Woof");
	}
	
	//A dog constructor assigning all attributes user specified attributes with input validation on the movement type
	public Dog(String color, String movementType, int numOfLegs)
	{
		super(color);
		
		//The only types of movements permittable by a dog is walk and swim. A dog cannot fly!
		if(!(movementType.equalsIgnoreCase("Walk") || movementType.equalsIgnoreCase("Swim")))
		{
			try
			{
				throw new MovementTypeException("A dog cannot " + movementType);
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
			this.setSound("woof");
		}
	}
	//The implementation of move specific to a dog.
	void move()
	{
		System.out.println("The dog is able to " + this.getMovementType());
	}
	
}
