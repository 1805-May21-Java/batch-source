package com.revature.animal;

import com.revature.exceptions.FoodExceptions;

public class AnimalDriver
{
	public static void main(String[] args) throws FoodExceptions
	{
		Cat cat1 = new Cat("Cali", true, 0, 8);
		Cow cow1 = new Cow("Bessy", true, 0, 200);
		
		cat1.makeNoise();
		try
		{
			cat1.eat("grass");
		}
		catch (FoodExceptions e)
		{
			e.printStackTrace();
		}
		System.out.println(cat1.isCarnavore());
		//since Cat extends Mammal I did not need to re-write the speedUp or slowDown methods
		//because they were defined in Mammal
		//this demonstrates inheritance
		cat1.speedUp(5);
		System.out.println(cat1.getSpeed());
		cat1.slowDown(2);
		System.out.println(cat1.getSpeed());

		cow1.makeNoise();
		try
		{
			cow1.eat("meat");
		}
		catch (FoodExceptions e)
		{
			e.printStackTrace();
		}
		System.out.println(cow1.isHerbavore());
		cow1.speedUp(2);
		System.out.println(cow1.getSpeed());
		cow1.slowDown(1);
		System.out.println(cow1.getSpeed());
		
	}

}
