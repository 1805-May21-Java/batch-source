package com.revature.Q12;

import java.util.*;

public class Q9 {

	public static void main(String[] args) {
		//Intialize array for integers
		ArrayList<Integer> Num = new ArrayList<Integer>();
		int i=0;
		//Fill array from 1-100
		for(i=1;i<=100;i++) {
			Num.add(i);
		}
		//Navigate through array printing only Primes
		for(int count:Num) {
			for(i=2;i<count;i++) {
				if(count%i==0)
					break;
			}
			if(i==count) {
				System.out.print(count+ " ");
			}
		}
	}
}


