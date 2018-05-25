package com.revature.qEighteen;

public class ManipulatorOfStrings extends StringManipulators
{
	public ManipulatorOfStrings()
	{
		super();
	}

	public boolean hasUpperCase(String value)
	{
		char[] characters = value.toCharArray();
		for(char character : characters)
		{
			if(Character.isUpperCase(character))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String value)
	{
		return value.toUpperCase();
	}

	@Override
	public void numberManipulation(String value)
	{
		try
		{
			int numericValue = Integer.parseInt(value);
			numericValue += 10;
			System.out.println(numericValue);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Input is not an integer");
		}
	}

}
