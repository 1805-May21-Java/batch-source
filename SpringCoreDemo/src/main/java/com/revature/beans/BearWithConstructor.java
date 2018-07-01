package com.revature.beans;

public class BearWithConstructor extends Bear{
	
	private int id;
	private String name;
	private Cave cave;
	
	
	public BearWithConstructor(Cave cave) {
		super();
		this.cave = cave;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BearWithConstructor [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	
	@Override
	public void methodInBear() {
		System.out.println("Method with BearWithConstructor. this bear is: " + toString());
	}
	
	

}
