package com.revature.core_java_assignment;

public class Question13 {

	public static void main(String[] args) {
		String str = "";
		for(int i = 0; i < 4; i++) {
			if(i % 2 == 0)
				str = "0 " + str;
			else
				str = "1 " + str;
			System.out.println(str);
		}
	}

}
