package com.revature.model;

public class Firework {
	
	String name;
	String color;
	int explosivePower;
	public Firework() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Firework(String name, String color, int explosivePower) {
		super();
		this.name = name;
		this.color = color;
		this.explosivePower = explosivePower;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getExplosivePower() {
		return explosivePower;
	}
	public void setExplosivePower(int explosivePower) {
		this.explosivePower = explosivePower;
	}
	@Override
	public String toString() {
		return "Firework [name=" + name + ", color=" + color + ", explosivePower=" + explosivePower + "]";
	}
	
	

}
