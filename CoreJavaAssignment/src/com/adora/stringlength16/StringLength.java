package com.adora.stringlength16;

public class StringLength {

	public static void main(String[] args) {
		
		int length = 0;

		if(args.length > 0) {
			for(String arg : args) {
				length += arg.length();
			}
		}
		
		System.out.println(length);

	}

}
