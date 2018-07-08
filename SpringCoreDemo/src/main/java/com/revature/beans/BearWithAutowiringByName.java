package com.revature.beans;

public class BearWithAutowiringByName extends Bear {
	//autowiring by name uses setter injection 
	//must be a setter which has the same name as the bean
	
	private int id;
	private String name;
	private Cave cave;
	
	public void setCave(Cave cave) { //setMyCave would not set our cave
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "BearWithAutowiringByName [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	
	@Override
	public void methodInBear() {
		System.out.println("method in BearWithAutowiringByName. this bear is: "+toString());
	}

}
