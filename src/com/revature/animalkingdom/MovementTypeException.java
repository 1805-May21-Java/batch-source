package com.revature.animalkingdom;


/* An example of a MovementTypeException would be thrown when a user 
	tries to declare a fish to walk. A fish cannot walk on land */
public class MovementTypeException extends Exception
{
	
	//Constructor for a movement type exception using Exceptions constructor.
	public MovementTypeException()
	{
		super();
	}
	
	//Constructor for a movement type using the super classes construtor and passing a custom message
	public MovementTypeException(String message)
	{
		super(message);
	}
}
