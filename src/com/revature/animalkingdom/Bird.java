package com.revature.animalkingdom;

//Bird represents inheritance by extending the animal class
public class Bird extends Animal implements Moving 
{
	
	//Default constructor for a bird using the animal's constructor to assign various attributes
	public Bird()
	{
		super("fly", "black", "chirp", 2);
	}
	
	//A bird constructor for if the user only knows the color of the bird.
	public Bird(String color)
	{
		super(color);
		this.setMovementType("fly");
		this.setNumOfLegs(2);
		this.setSound("chirp");
	}
	
	//A bird constructor assigning all attributes user specified attributes with input validation on the movement type
	public Bird(String color, String movementType, int numOfLegs)
	{
		super(color);
		
		//The only types of movements permittable by a bird is flying and walking. A bird cannot swim!
		if(!(movementType.equalsIgnoreCase("Walk") || movementType.equalsIgnoreCase("fly")))
		{
			try
			{
				throw new MovementTypeException("A bird cannot " + movementType);
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
			this.setSound("chirp");
		}
	}
	//The implementation of move specific to a bird.
	void move()
	{
		System.out.println("The bird is able to " + this.getMovementType());
	}

}
