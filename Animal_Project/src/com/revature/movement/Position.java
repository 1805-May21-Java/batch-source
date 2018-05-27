package com.revature.movement;


//keeps track of the position
//x is east/west, y is north/south, z is up/down
public class Position {

	protected int x;
	protected int y;
	protected int z;
	
	public int getX() {
		return x;
	}
	public void changeX(int x) {
		System.out.println(x);
		this.x += x;
	}
	public int getY() {
		return y;
	}
	public void changeY(int y) {
		this.y += y;
	}
	public int getZ() {
		return z;
	}
	public void changeZ(int z) {
		this.z += z;
	}
	
}
