package com.revature.animal;
import com.revature.exceptions.FoodExceptions;

//Implements is a kind of inheritance just for interfaces
public class Mammal implements Animal
{
	protected String name;
	
	protected boolean isAlive;
	
	protected int speed;
	protected int weight;
	
	public Mammal()
	{
		super();
	}
	
	public Mammal(String name, boolean isAlive, int speed, int weight)
	{
		super();
		this.name = name;
		this.isAlive = isAlive;
		this.speed = speed;
		this.weight = weight;
	}

	//getter and setters methods are a prime example of encapsulation
	//they hide information from other classes and methods ensuring the data is safe
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	//overriding the methods in the interface class is an example of polymorphism as it changes the original methods
	@Override
	public void speedUp(int increment)
	{
		this.speed += increment;
	}
	
	@Override
	public void slowDown(int decrement)
	{
		this.speed -= decrement;
	}
	
	@Override
	public void eat(String food) throws FoodExceptions
	{

		System.out.println(this.name+" ate the "+food);
		weight += 1;
	}

}
