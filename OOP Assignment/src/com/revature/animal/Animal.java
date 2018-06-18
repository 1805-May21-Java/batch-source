package com.revature.animal;
import com.revature.exceptions.FoodExceptions;

//This interface demonstrates abstraction by hiding the implementation of the methods
public interface Animal 
{
	default void makeNoise()
	{
		System.out.println("Animal noises");
	}

	void speedUp(int increment);
	
	void slowDown(int decrement);
	
	void eat(String food) throws FoodExceptions;

}
