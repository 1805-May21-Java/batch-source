package com.Revature.Generals;

public class Question10 {
	public static int getGreatest(int n1 , int n2 ) {
		return (n1<n2)?n1:n2;
		//Equates to if (n1 < n2 ) { return n1;} else { return n2; }
	}
	public static void main(String[] args ) {
		System.out.println(getGreatest(10,1));
		System.out.println(getGreatest(3,6));
	}
}
