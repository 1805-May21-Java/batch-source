package com.revature.a2;

public class Q5Substring {
	private String subs;
	//already needs inputting a string and a number
	public void substring(String str, int idx) {
		subs = "";
		try {
			// add each letter until it hit the number
			for(int i = 0; i < idx; i++) {
				subs = subs + str.charAt(i);
			}
			System.out.println(subs);
			System.out.println();
		} catch(StringIndexOutOfBoundsException e) {
			//prevent the number to be larger than string length
			System.out.println("The number entered can not be larger than string length!");
		}
	}
}
