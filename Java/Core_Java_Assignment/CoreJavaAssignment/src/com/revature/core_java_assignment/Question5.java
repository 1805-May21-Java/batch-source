package com.revature.core_java_assignment;

public class Question5 {

	public static String substring(String str, int index) {
		String result = "";
		
		for(int i = 0; i < index; i++) {
			result += str.charAt(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "Hello, World!";
		System.out.println(substring(str, 5));
	}

}
