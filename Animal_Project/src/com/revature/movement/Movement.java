package com.revature.movement;

//describes a single movement, with the four cardinal directions, 
//or four cardinal directions and up and down if animal flies or swims
//North, East, Up all positive, South, West, Down all negative
public class Movement {
	protected int moveNorthSouth = 0;
	protected int moveEastWest = 0;
	protected int moveUpDown = 0;
	
	public Movement(int northSouth, int eastWest) {
		this.moveEastWest = eastWest;
		this.moveNorthSouth = northSouth;
	}

	public Movement(int northSouth, int eastWest, int upDown) {
		this.moveEastWest = eastWest;
		this.moveNorthSouth = northSouth;
		this.moveUpDown = upDown;
	}

	//Getters for directions, directions should never be changed so no setters
	public int getMoveNorthSouth() {
		return moveNorthSouth;
	}

	public int getMoveEastWest() {
		return moveEastWest;
	}

	public int getMoveUpDown() {
		return moveUpDown;
	}
	

	
	
}
