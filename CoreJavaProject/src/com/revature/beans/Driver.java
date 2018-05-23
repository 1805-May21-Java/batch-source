package com.revature.beans;
import java.lang.reflect.*;
public class Driver {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Bicycle b1 = new Bicycle();
		
		b1.speedUp(14);
		b1.slowDown(7);
		System.out.println();
		
		b1.equals(b1);
		b1.hashCode();
		
		Class cls = b1.getClass();
        System.out.println("The name of class is " +cls.getName());
        
		//Vehicle v1 = new Bicycle();
		//v1.speedUp(5);
		//v1.speedUp(7);
		//System.out.println();
		
		//Vehicle.StaticMethod();
		//Bicycle.StaticMethod();
		
		//Submarine s1 = new Submarine();
		//s1.Ammunition(5);
		//s1.shoot(6);
		
		
	}

}
