package com.revature.homework;

public class Q5 {

	public static void main(String[] args) {
		//Q5.subString("hello", 2);
		String string = "hellow";
		//System.out.println(string);
		System.out.println( subString(string, 2)); // implementing static method
		System.out.println( subString(string, 5));
		System.out.println( subString(string, 4));
		System.out.println( subString(string, 1));
	}
	
  public static String subString(String str, int idx) {
	  if(idx> str.length()) { // if index is greater then the length of string 
	return str;
	  
	  }
	  String sb = "";
	  for(int i = 0; i<idx; i++) { // loop through index 
		  sb = sb + str.charAt(i);
     
}
	   return sb;// return the index string 
  }
  }