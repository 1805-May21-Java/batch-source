package com.revature.corejava;
//Q13
public class TriangleDisplay {

	public static void main(String[] args) {
		String string = "";
		for(int i=0; i<4; i++) {
			string = i%2+string;
			System.out.println(string);
		}
	}

}
