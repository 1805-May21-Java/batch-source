package com.revature.question6;

import com.revature.sharedfunctionality.intGetter;

public class EvenTest extends intGetter
{
	public EvenTest()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Recursively tests whether a number is even or odd
	 * @return true if the number is even, false if the number is odd
	 */
	private boolean testNumber(int testee)
	{
		String value = "" + testee;
		char lastDigit = value.charAt(value.length() - 1);
		return ((lastDigit == '0') || (lastDigit == '2') || (lastDigit == '4') || (lastDigit == '6') || (lastDigit == '8'));
	}
	
	public void numberTester()
	{
		System.out.print("Enter an integer: ");
		int value = getInt();
		boolean result = testNumber(value);
		
		if(result)
			System.out.println(value + " is even");
		else
			System.out.println(value + " is odd");
	}
}
