package com.revature.core_java_assignment;

public class Q18_SubClass extends Q18_AbstractClass
{
	
	public Q18_SubClass()
	{
		super();
	}

	//overriding the method and using .equals() and .toLowerCase() to check for upper case characters
	//if the original str is not equal to it's all lower case version that means it has an upper case
	@Override
	public boolean checkUpperCase(String str)
	{
		boolean hasUpperCase;
		
		if(hasUpperCase = !str.equals(str.toLowerCase()))
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	//simply calling the string function .toUpperCase() to convert everything to upper case
	@Override
	public String convertLowerToUpper(String str)
	{
		return str.toUpperCase();
	}
	
	//converting the str input into an int with Interger.parseInt() and then adding 10 an returning the result
	@Override
	public int convertStringToIntPlusTen(String str)
	{
		int num = Integer.parseInt(str);
		num += 10;
		return num;
	}


}
