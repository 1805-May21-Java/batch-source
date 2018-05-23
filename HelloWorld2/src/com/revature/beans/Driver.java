package com.revature.beans;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Declaring bicycle object as a object");
		Bicycle b1 = new Bicycle();
		b1.speedUp(5);
		b1.speedUp(7);
		
		Vehicle v1 = new Bicycle();
		v1.speedUp(5);
		v1.speedUp(7);
		System.out.println("Declaring bicycle object as a object");

		System.out.println("Declaring vehicle object as a vehicle");
		Vehicle v2 = new Bicycle();
		v2.speedUp(5);
		v2.speedUp(7);
		
		Vehicle.staticMethod();
		Bicycle.staticMethod();
		
	}
	


}
