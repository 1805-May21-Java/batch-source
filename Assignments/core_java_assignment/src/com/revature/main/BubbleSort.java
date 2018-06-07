package com.revature.main;


public class BubbleSort {

	BubbleSort()
	{
		super();
	}
	
	/**
	 * This is the bubble sort function
	 * To achieve bubble sort we use two for loops to iterate through Integer list
	 * The first iteration from j to array.length-1 is to make sure that the item's neighbor placed in right position
	 * The second iteration from i to array.length is to make sure that all items place int the right position
	 * 
	 */
	public static void sort(Integer[] array)
	{
		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array.length-1;j++)
			{
				int temp=array[j];
				if(array[j]>array[j+1])
				{
					array[j]=array[j+1];
					array[j+1]=temp;
				}

			}
		}
	}
}
