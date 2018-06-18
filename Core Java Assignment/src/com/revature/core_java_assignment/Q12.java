package com.revature.core_java_assignment;

public class Q12
{

	public static void main(String[] args)
	{
		//creating a new array with 100 indexes
		int[] arr = new int[100];
		
		//populating the array
		for(int i = 0; i < 100; i++)
		{
			arr[i] = i+1;
		}
		
		//iterating through the array with the enhanced for loop
		for(int j : arr)
		{
			//determining if the number is even if so displaying it
			if(j%2 == 0)
			{
				System.out.println(j);
			}
		}
	}

}
