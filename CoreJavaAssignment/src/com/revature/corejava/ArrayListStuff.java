package com.revature.corejava;

import java.util.ArrayList;

//Q19
public class ArrayListStuff {

	public static void main(String[] args) {
		ArrayList<Integer> intArray = new ArrayList<>();
		for(int i=0; i<=10; i++) {
			intArray.add(i);
		}
		
		int evenSum=0, oddSum=0;
		for(int i: intArray) {
			if(i%2==0) {
				evenSum+=i;
			}
		}
		for(int i: intArray) {
			if(i%2==1) {
				oddSum+=i;
			}
		}
		System.out.println("Even Sum: "+evenSum);
		System.out.println("Odd Sum:  "+oddSum);
		for(int i=0; i<intArray.size(); i++) {
			int a = intArray.get(i);
			if(a!=1 && (isPrime(a) || a == 2)) {
				intArray.remove(i);
				i--;
			}
			
		}
		for(int j: intArray) {
			System.out.print(j+" ");
		}
	}
	//Checks if a number is prime by checking if a number is divisible by another number with no remainder
	public static boolean isPrime(int n) {
		if(n%2 == 0) return false;
		for(int i=3; i<n; i+=1) {
			if(n%i==0) return false;
		}
		return true;
	}

}
