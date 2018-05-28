package com.revature.corejava;

public class Triangle {

	public static void main(String[] args) {
		
		boolean flagOuter = true; // used to determine if first number is 0 or 1
		
		// print triangle
		for (int i=0; i<4; i++) {
			boolean flagInner = flagOuter;
			for (int j=0; j<i+1; j++) {
				if (flagInner) {
					System.out.print(0 + " ");
				} else {
					System.out.print(1 + " ");
				}
				flagInner = !flagInner;
			}
			System.out.println();
			flagOuter = !flagOuter; // change from 0 to 1 or vice-versa
		}

	}

}
