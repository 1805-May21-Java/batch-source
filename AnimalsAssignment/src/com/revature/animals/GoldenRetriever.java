package com.revature.animals;

import com.revature.exceptions.TennisBallsException;
import com.revature.interfaces.MakesNoise;

//GoldenRetriever class inheriting from Dog
public class GoldenRetriever extends Dog implements MakesNoise {
 
	private String furColor = "Golden";
	
	//Fetch method that uses try/catch block to address potential TennisBallsException
	public void fetch(int numOfTennisBalls, String name) {
		if (numOfTennisBalls > 5) {
			try { 
				throw new TennisBallsException("That was too many tennis balls!");
			} catch (TennisBallsException e) {
				e.printStackTrace();
			}
		} else {
		System.out.println(name +" fetched " + numOfTennisBalls + " tennis balls!" );
	}
	}

	//Constructors
	public GoldenRetriever() {
		super();
	}

	public GoldenRetriever(String favoriteFood) {
		super(favoriteFood);
	}
	
	//Getters and Setters encapsulate data in class
	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	
}
