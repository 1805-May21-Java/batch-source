package com.revature.beans;

public class Bear {
	
	protected int id;
	protected String name;
	protected Cave cave;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cave getCave() {
		return cave;
	}
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	
	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	
	public void methodInBear() {
		System.out.println("method in bear invoked");
	}

}
