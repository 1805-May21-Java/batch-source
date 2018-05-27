package com.revature.assignment;

public class QuestionFive {
	
	private static String str = "This is my test string.";
	private static String finalStr = "";
	private static int idx = 12;
	
	private void substring(String str, Integer idx) {
		
		//loops as long as i is less than the given index and adds each character to a final string
		for(int i=0; i<idx; i++) {
			finalStr += str.charAt(i);
		}
		System.out.println(finalStr);
	}
	
	//uses method created
	public static void main(String[] args) {
		
		QuestionFive qf = new QuestionFive();
		qf.substring(str, idx);		
	}
}
