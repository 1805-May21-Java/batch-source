package com.revature.corejava;

/*
 * Q1 from Core Java Assignment
 * 
 * Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */
public class BubbleSort
{

	public static void main(String[] args) 
	{
		int[] intArr = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("Array unsorted: ");
		
		for( int i = 0; i< intArr.length; i++)
		{
			System.out.print(intArr[i] + " ");
		}
		
		System.out.println();
		System.out.println("Array sorted: ");
		bubble(intArr);
		
		for( int i = 0; i< intArr.length; i++)
		{
			System.out.print(intArr[i] + " ");
		}
	}

	
	
	static void bubble(int[] arr)
	{
		int temp;
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 1; j < (arr.length - 1); j++)
			{
				if(arr[j-1] > arr[j])
				{
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
			
	}
}
