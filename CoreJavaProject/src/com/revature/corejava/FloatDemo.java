package com.revature.corejava;

import com.revature.floating.Float;

/*
 * Q11 from Core Java Assignment
 * 
 * Write a program that would access two float-variables from a class that exists in another package. 
 * Note, you will need to create two packages to demonstrate the solution.
 */
public class FloatDemo 
{

	public static void main(String[] args) 
	{
		//I instantiate a float object so that I can access the floats stored in another package
		Float f = new Float();
		//I access the 2 floats stored in that package showing they are set to 0
		System.out.println("float 1's value is: " + f.getFloat1());
		System.out.println("float 2's value is: " + f.getFloat2());
		//I use my setters to change the value of those 2 floats then print again
		f.setFloat1(4f);
		f.setFloat2(6f);

		System.out.println("float 1's value is: " + f.getFloat1());
		System.out.println("float 2's value is: " + f.getFloat2());
		
		
		
	}
}
