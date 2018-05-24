package com.revature.beans;

public class Question1 
{

	public static void main(String[] args)
	{
		int[] values = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		print(values);
		boolean hasChanged; //If it goes through the entire array without changing anything, it's sorted
		
		//A number can move up to the length of the array, so the algorithm runs at most that many times
		for(int timesThrough = 0; timesThrough < values.length; timesThrough++)
		{
			hasChanged = false;  //At the beginning of a pass, nothing has changed so reset hasChanged
			for(int i = 0; i < (values.length - 1); i++)
			{
				int current = values[i];
				int next = values[i + 1];
				if(current > next)
				{
					values[i] = next;
					values[i + 1] =  current;
					print(values);
					hasChanged = true;
				}
			}
			//Eliminates any unecessary passes
			if(!hasChanged)
			{
				break;
			}
		}
		print(values);
	}
	
	public static void print(int[] values)
	{
		System.out.print("{");
		for(int i = 0; i < values.length - 1; i++)
		{
			System.out.print(values[i] + ", ");
		}
		System.out.println(values[values.length - 1] + "}");
	}
}
