package com.revature.animal;
import com.revature.exceptions.FoodExceptions;

//extending another class is an example of inheritance 
public class Cat extends Mammal
{
	private boolean isCarnavore = true;
	
	public Cat()
	{
		super();
	}

	public Cat(String name, boolean isAlive, int speed, int weight)
	{
		super(name, isAlive, speed, weight);
	}

	public boolean isCarnavore()
	{
		return isCarnavore;
	}

	//this method is an example of plomorphism by overriding, redefining the method in this sublcass
	public void eat(String food) throws FoodExceptions
	{
		if(food != "meat" || food != "fish")
		{
			throw new FoodExceptions("Cats are carnavores, they eat meat and fish");
			
		}
		System.out.println(this.name+" ate the "+food);
		this.weight += 1;
	}
	//This is an example of polymorphism this method is overriding the interface method
	public void makeNoise()
	{
		System.out.println("Meow!");
	}
	
}
