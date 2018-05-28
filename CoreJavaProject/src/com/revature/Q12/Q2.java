package com.revature.Q12;

import java.util.Arrays;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fiba[] = new int[25];
		fiba[0]=0;
		fiba[1]=1;
		for(int i=2; i<25;i++) {
			fiba[i] = fiba[i-1]+ fiba[i-2];
		}
		System.out.println(Arrays.toString(fiba));
	}

}
