package com.revature.beans;

public class BearWithAutowiringByType extends Bear {
	// again this is going to use setter injection
	// our IOC container is going to look for a bean with the specified type 
	// and inject it
	
	private int id;
	private String name;
	private Cave cave;
	
	
	public void setAnythingWeWant(Cave cave) {
		this.cave = cave;
	}


	@Override
	public String toString() {
		return "BearWithAutowiringByType [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	
	@Override 
	public void methodInBear() {
		System.out.println("method in BearWithAutowiringByType. this bear is: "+ toString());
	}
	
	
	
}
