package com.revature.assignment;

public class QuestionOne {
	
	private void bubbleSort(int intArray[]) {
		
		int len = intArray.length;
		
		//for loops cycles through twice, one to test each item and one to move that item to the
		//appropriate place
		for(int i = 0; i < len-1; i++)
			for(int j = 0; j < len-i-1; j++)
				if(intArray[j] > intArray[j+1]) {
					int temp = intArray[j];
					intArray[j] = intArray[j+1];
					intArray[j+1] = temp;
				}
	}
		
	//method used to print an array, loops through each item and adds a space
	private void printArray(int intArray[]) {
		
		int len = intArray.length;
		
		for(int i=0; i<len; ++i)
			System.out.print(intArray[i] + " ");
		
		System.out.println();
	}
	
	//creates array, sorts it, and prints the result
	public static void main(String[] args) {
		
		int intArray[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		QuestionOne qo = new QuestionOne();
		qo.bubbleSort(intArray);
		
		System.out.println("Bubble Sorted Array:");
		qo.printArray(intArray);
	}
}
					