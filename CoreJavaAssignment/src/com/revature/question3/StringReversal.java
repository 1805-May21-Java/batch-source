package com.revature.question3;

public class StringReversal
{
	public StringReversal()
	{
		super();
	}

	public String reverseString(String value)
	{		
		StringBuffer bufferedValue = new StringBuffer(value);
		
		//Working backward, append all chars to the end
		for(int i = value.length() - 1; i >= 0; i--)
		{
			bufferedValue.append(bufferedValue.charAt(i));
		}
		
		//Delete the original values by deleting indexes 0-value.length()
		bufferedValue.delete(0, value.length());
		
		return bufferedValue.toString();
	}
}
