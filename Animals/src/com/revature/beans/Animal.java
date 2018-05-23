package com.revature.beans;

import com.revature.exceptions.NegativeWeightException;

//Abstract class allows for abstraction by combining common data and functionality
public abstract class Animal 
{
	protected String name;
	protected int weight;
	
	public Animal() 
	{
		super();
	}

	public Animal(String name, int weight) 
	{
		super();
		this.name = name;
		this.weight = weight;
	}

	//Getters and setters allow for encapsulation
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getWeight() 
	{
		return weight;
	}

	public void setWeight(int weight) throws NegativeWeightException
	{
		try
		{
			if(weight <= 0)
			{
				throw new NegativeWeightException(this.name + "'s weight must be more than zero");
			}
			this.weight = weight;
		}
		catch(NegativeWeightException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String toString()
	{
		return "The animal " + this.name + " is " + this.weight +"lb";
	}
	
	//I want to define how each animal plays, but no animal plays the same, so I use abstraction to do this
	public abstract void play();
}
