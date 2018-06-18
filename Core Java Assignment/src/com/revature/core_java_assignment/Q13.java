package com.revature.core_java_assignment;

public class Q13
{

	public static void main(String[] args)
	{
		//using nested for loops to achieve the desired output
		//first loop keeps track of what line we are on
		for(int i = 1; i <= 4; i++)
		{
			//the second loop is our 
			//the loop is going backwards to display the numbers properly
			for(int j = i; j > 0; j--)
			{
				if(j%2 == 0)
				{
					System.out.print("1");
				}
				else
				{
					System.out.print("0");
				}
			}
			System.out.println();
		}

	}

}
