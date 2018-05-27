package com.adora.triangle13;

public class PrintTriangle {

	public static void main(String[] args) {
		

		int lines = 4;
		
		for (int i = 0; i < lines; i++) {

			int charCount = 0;
			if(i % 2 != 0) {
				charCount++;
			} 
			
			for(int j = 0; j <= i; j++) {		
				
				if(charCount % 2 == 0) {
					System.out.print("0 ");
				} else {
					System.out.print("1 ");
				}
				
				charCount++;
		
			}
			System.out.println();
		}
	}

}
