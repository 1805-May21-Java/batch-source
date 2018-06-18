package com.revature.core_java_assignment;

public class Q2
{
	public static void main(String[] args)
	{
		//declaring variables
		int fn = 0;
		//the first value
		int f1 = 0;
		//the second value
		int f2 = 1;
		
		for(int i = 0; i < 25; i++)
		{	
			if( i <= 1)
			{
				//taking care of the first cases ie: 0 1
				fn = i;
			}
			//computes the rest after i > 1
			//Fibonacci sequence is the previous two numbers adding together after the initial seed(0 1 in this case)
			else
			{
				fn = f1 + f2;
				f1 = f2;
				f2 = fn;
			}
			//displays the results
			System.out.println(fn);
		}
	}

}
