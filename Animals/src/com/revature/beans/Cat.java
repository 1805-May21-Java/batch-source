package com.revature.beans;

import com.revature.exceptions.NegativeWeightException;
import com.revature.exceptions.OneToTenException;

//I use inheritance to avoid duplicate code with functionality provided in Animal
public class Cat extends Animal 
{
	private double agression;
	//I use polymorphism to override the superclass's sound variable to make it a final variable
	final static String SOUND = "meow";
	
	public Cat() 
	{
		super();
	}


	public Cat(String name, int weight, double agression) 
	{
		super(name, weight);
		this.agression = agression;
	}


	public Cat(double agression) 
	{
		super();
		this.agression = agression;
	}
	
	public double getAgression()
	{
		return this.agression;
	}
	
	//I want the agression to be between 1 and 10, so I use an exception to guarantee that
	public void setAgression(double agression) throws OneToTenException
	{
		try
		{
			if((agression < 0) || (agression > 10))
			{
				throw new OneToTenException("Agression must be between 1 and 10");
			}
			this.agression = agression;
		}
		catch(OneToTenException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void play() 
	{
		System.out.println("You expect a cat to PLAY?");
	}
	
	//I use polymorphism to override the super class's toString to add the animal type, sound, and agression
	public String toString()
	{
		return "The cat " + this.name + " weighs " + this.weight + "lb and says " + SOUND + ".  Careful it is " + agression + " agressive out of 10";
	}

}
