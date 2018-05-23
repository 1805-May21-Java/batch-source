package com.revature.arrays;

import java.util.Arrays;

public class ArrayDriver {

	public static void main(String[] args) {
		
		// 1D arrays
		int[] intArray1 = new int[5];
		int intArray2[] = new int[5];
		int[] intArray3 = {1,7,4,2,9};
		
		System.out.println(intArray3[0]);
		System.out.println(intArray3[3]);
		
		System.out.println(intArray3[10]);
		//this gives us an ArrayIndexOutofBoundsException
		
		System.out.println(Arrays.toString(intArray3));
		System.out.println(Arrays.binarySearch(intArray3,9));
		System.out.println(Arrays.binarySearch(intArray3,3));
				
		//2D array
		
//		int[][] int2DArray1 = new int[5][2];
//
//		int int2DArray2[][] = new int[5][2];
//		
//		int[] int2DArray3[] = new int [5][2];
		
		int[][] int2DArray4 = {{2},{3,6,3},{2,6},{9,3,1}};
		
		for(int i = 0; i < int2DArray4.length; i++) {
			
			for(int j = 0; j < int2DArray4[i].length; j++) {
				System.out.println(int2DArray4[i][j] + " ");
			}
			System.out.println();
		}

	}
	
}
