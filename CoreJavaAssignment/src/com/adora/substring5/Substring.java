package com.adora.substring5;

public final class Substring {

//	public static void main(String[] args) {
//		System.out.println(getSubstring("Welcome", 4));
//
//	}
	
	public static final String getSubstring(String string, int index) {
		String substring = "";
		for(int i = 0; i < index; i++) {
			substring += string.charAt(i);
		}
		return substring;
	}

}
