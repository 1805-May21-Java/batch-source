package com.revature.corejava;

//AbstractClassImpl is a concrete subclass inheriting three abstract methods from MyAbstractClass
public class AbstractClassImpl extends MyAbstractClass
{


	public AbstractClassImpl()
	{
		super();
	}

	//I iterate thru each character of the string and see if it uppercase, if none are found false is returned
	@Override
	public boolean containsUppercaseChars(String str) 
	{
		for(int i = 0; i <str.length(); i++)
		{
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch))
				return true;
			
		}
		return false;
	}

	//I used the String API's toUpperCase to convert the string then return the string
	@Override
	public String toUpperCase(String str) 
	{
		return str.toUpperCase();
	}

	//I get the an integer value representation of the string then return that value + 10
	@Override
	public Integer toInteger(String str) 
	{
		Integer result = Integer.valueOf(str);
		return result + 10;
	}

}
