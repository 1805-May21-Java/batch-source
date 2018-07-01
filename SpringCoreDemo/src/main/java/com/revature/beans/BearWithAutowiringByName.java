package com.revature.beans;

public class BearWithAutowiringByName extends Bear{

	private int id;
	private String name;
	private Cave cave;
	public BearWithAutowiringByName(Cave cave) {
		super();
		this.cave = cave;
	}
	
	public Cave getCave() {
		return cave;
	}
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	@Override
	public String toString() {
		return "BearWithAutowiringByName [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	
	@Override
	public void methodInBear() {
		System.out.println("Method in BearwithAutowiring, this bear is: " + toString() );
	}
	
	
	
}
