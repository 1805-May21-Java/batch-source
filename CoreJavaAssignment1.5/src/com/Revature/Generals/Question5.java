package com.Revature.Generals;

public class Question5 {
	public static String getSubStr(String str , int idx) {
		String nStr = ""; //Initialize empty string
		for ( int i = 0; i < idx; i++ ) {
			nStr+=str.charAt(i); //Append new string with all char
			//Up till idx-1 inclusively
		}
		return nStr;
	}
	
	public static void main(String[] args) {
		System.out.println(getSubStr("Thomas Jansen",6));
	}
}
