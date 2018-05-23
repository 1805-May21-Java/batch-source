package com.revature.array;

import java.util.Arrays;

public class ArrayDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1D Arrays
		int[] intArray1 = new int[5];
		int intArray2[] = new int[5];
		int[] intArray3 = {7,2,2,5,5};
		
		System.out.println(intArray1[3]);
		System.out.println(intArray2[4]);
		System.out.println(intArray3[2]);
		
		//Prints out your array as a string
		System.out.println(Arrays.toString(intArray3));
		
		//Tells you index that value 5 is at in intArray3
		System.out.println(Arrays.binarySearch(intArray3, 5));
		
		//2D Array
		int [][] int2DArray = new int[5][2];
		//int int2DArray2[][] = new int[5][2];
		//int []int2DArray3[] = new int[5][2];
		int [][] int2DArray4 = {{2},{3,6,3},{2,6},{9,3,1}};
		
		System.out.println();
		
		for(int i = 0; i< int2DArray.length; i++) {
			for(int j=0;j<int2DArray4[i].length; j++) {
				System.out.print(int2DArray4[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
