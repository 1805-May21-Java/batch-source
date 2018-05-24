package com.revature.algorithms;

public class Substring {

	public Substring() {
		super();
	}

	// takes string str and returns the substring from 0 to index n-1
	public static String substring(String str, int idx) {
		StringBuffer sub = new StringBuffer();
		for(int i = 0; i < idx && i < str.length(); i++) {
			sub.append(str.charAt(i));
		}
		return sub.toString();
	}
}
