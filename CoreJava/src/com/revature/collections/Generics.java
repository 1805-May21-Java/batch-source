package com.revature.collections;

import java.util.ArrayList;

public class Generics {
	
	public static void main(String[] args) {
		
		// our compiler does not stop us from doing this
//		ArrayList arrList = new ArrayList();
//		arrList.add("test");
//		Integer i = (Integer) arrList.get(0);
		
		// we can assure type safety with generics!!
		// another way of parameterizing type
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("test");
		//Integer i = (Integer) arrList.get(0);
		//we see a compile time error, assuring the type safety of our collection
		//and preventing the ClassCastException from occurring
		
		Integer[] iArr = {1,2,3,4,5};
		Character[] cArr = {'h','e','l','l','o'};
		
//		printMe(iArr);
//		printMe(cArr);
		
	}

//	public static void printMe(Integer[] arr) {
//		for(Integer i : arr) {
//			System.out.println(i);
//		}
//	}
//	
//	public static void printMe(Character[] arr) {
//		for(Character i : arr) {
//			System.out.println(i);
//		}
//	}
	
	//use generics in order to parameterize
	public static <T> void printMe(T[] arr) {
		for(T i: arr) {
			System.out.println(i);
		}
	}
	
}
