package com.revature.main;


/**
 * This class is created regarding Question 18
 * We created this class as an abstract class in order to create abstract method so its subclass can extends and implement the abstract methods.
 *
 */
public abstract class StringTool
{

	
	public StringTool()
	{
		// TODO Auto-generated constructor stub
	}
	
	abstract boolean isUpperCase(String str);
	abstract String toUpperCase(String str);
	abstract int toIntegerPlusTen(String str);

}
