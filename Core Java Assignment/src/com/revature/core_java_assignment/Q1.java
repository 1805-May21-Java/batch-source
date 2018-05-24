package com.revature.core_java_assignment;
import java.util.Arrays;

public class Q1
{

	public static void main(String[] args)
	{
		//initializing the array
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		//creating a variable to temporarily store a value
		int temp = 0;
		
		//main loop
		for(int i = 0; i < arr.length; i++)
		{
			//secondary loop to ensure the array is sorted
			for(int j = 0; j < arr.length-1; j++)
			{
				//comparing the values of numbers next to each other in the array
				if(arr[j] > arr[j+1])
				{
					//using the temp variable here so I don't lose the value at position arr[j+1] by overwriting it too soon
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		//displaying the result
		System.out.println(Arrays.toString(arr));
	}
}
