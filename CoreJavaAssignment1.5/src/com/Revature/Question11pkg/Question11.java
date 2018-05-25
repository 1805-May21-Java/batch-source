package com.Revature.Question11pkg;

import java.lang.reflect.Field;

import com.Revature.HackMe.Car;

public class Question11 {
	public static void main(String args[]) {
		try {
			Class c1 = Class.forName("com.Revature.HackMe.Car"); //Access class
			System.out.println("Class: " + c1.getName()); //Print class name

			Car c = new Car(123.12f, 23.9f); //Create new Car
			//Can also be done using c1.newInstance

			Field mpg = c1.getDeclaredField("mpg"); //Get the two float fields in car
			Field miles = c1.getDeclaredField("miles");

			mpg.setAccessible(true); //Set them to be accessible
			miles.setAccessible(true);

			System.out.println("MPG given by constructor: " + mpg.getFloat(c)); //Print out their initial values
			System.out.println("Miles given by constructor: " + miles.getFloat(c));

			mpg.setFloat(c, 34.5f); //Set both floats to new values
			miles.setFloat(c, 100f);

			System.out.println("MPG after reflection: " + mpg.getFloat(c)); //Output new values
			System.out.println("Miles after reflection: " + miles.getFloat(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
