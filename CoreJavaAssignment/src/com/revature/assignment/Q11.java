package com.revature.assignment;

import com.revature.question11.Floats;

public class Q11 {

	//Q11. Write a program that would access two float-variables from a class that exists in another package. 
	//Note, you will need to create two packages to demonstrate the solution.
	
	//Package with float values is com.revature.question11 and the class is Floats
	//float values are public so they are able to be accessed by Q11 class and Driver
	public void addFloats(float f1, float f2) {
		float f3 = f1 + f2;
		System.out.println(f3);
	}
}

		//Driver Code
		//Q11 q = new Q11();
		//q.addFloats(Floats.f1, Floats.f1);