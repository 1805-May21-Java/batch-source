package com.revature.question12;

import java.util.ArrayList;

public class Question12Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = new int[101];
		ArrayList<Integer> iArray = new ArrayList<Integer>();
		for(int i=0;i<intArray.length;i++) {
//			System.out.println("inside: "+intArray.length);
			intArray[i]=i;
		    if( i % 2 == 0)
		    	iArray.add(i);
		}
		
		for(int i:iArray)
			System.out.println(i);

	}

}
