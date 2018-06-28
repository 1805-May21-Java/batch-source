package com.revature.beans;

public class BearWithSetter extends Bear {
	
	private int id;
	private String name;
	private Cave cave;
	
	public void setCave(Cave cave) {
		this.cave = cave;
	}
}
