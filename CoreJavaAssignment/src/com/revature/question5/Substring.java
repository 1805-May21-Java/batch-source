package com.revature.question5;

//intGetter allows the try/catch block for inputing an integer to be only written once
import com.revature.sharedfunctionality.intGetter;

public class Substring extends intGetter
{
	public Substring()
	{
		super();
	}

	public String findSubString(String fullString, int startIndex, int endIndex)
	{
		String result = "";
		
		for(int i = startIndex; i <= endIndex; i++)
		{
			result += fullString.charAt(i);
		}
		
		return result;
	}
	
	public void promptForRange(String fullString)
	{
		System.out.print("Enter the beginning index (0 based indexing): ");
		int startIndex = getInt();
		System.out.print("Enter the ending index: ");
		int endIndex = getInt();
		
		System.out.println("The result is: " + findSubString(fullString, startIndex, endIndex));
	}
}
