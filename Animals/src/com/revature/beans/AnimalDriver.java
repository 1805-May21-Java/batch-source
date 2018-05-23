package com.revature.beans;

import com.revature.exceptions.NegativeWeightException;

public class AnimalDriver 
{
	public static void main(String[] args) 
	{
		Cat flufferMcKitty = new Cat("Fluffer McKitty", 12, 9.8);
		Dog rover = new Dog("Rover", 20, "Fido");
		flufferMcKitty.play();
		System.out.println(flufferMcKitty);
		rover.play();
		System.out.println(rover);
		try 
		{
			flufferMcKitty.setWeight(-1);
			flufferMcKitty.setAgression(11.0);
			rover.setWeight(0);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
