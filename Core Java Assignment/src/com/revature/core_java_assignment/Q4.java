package com.revature.core_java_assignment;

public class Q4
{

	public static void main(String[] args)
	{
		//declaring a variable our N factorial
		int num = 5;
		
		//the loop which computes it using a counting down for loop counter
		//N! = N*N-1*N-2 and so on
		for (int i = 4; i > 0; i-- )
		{
			num *= i;
		}
		System.out.println(num);
	}

}
