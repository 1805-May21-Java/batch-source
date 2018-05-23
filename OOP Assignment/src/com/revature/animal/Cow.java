package com.revature.animal;
import com.revature.exceptions.FoodExceptions;

public class Cow extends Mammal
{
	private boolean isHerbavore = true; 
	
	public Cow()
	{
		super();
	}

	public Cow(String name, boolean isAlive, int speed, int weight)
	{
		super(name, isAlive, speed, weight);
	}
	
	public boolean isHerbavore()
	{
		return isHerbavore;
	}

	public void eat(String food) throws FoodExceptions
	{
		if(food != "grass")
		{
			throw new FoodExceptions("Cows are herbavores, they eat grass");
			
		}
		System.out.println(this.name+" ate the "+food);
		this.weight += 2;
	}

	public void makeNoise()
	{
		System.out.println("Moo!");
	}
	
}
