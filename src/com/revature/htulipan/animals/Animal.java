package com.revature.htulipan.animals;

public abstract class Animal {
	
	// Animal demonstrates Encapsulation by having private access-modifiers on its attributes,
	// which can only be seen and changed through getter and setter methods.
	private int numberOfEyes;
	private boolean terrestrial;
	private int age;
	private boolean alive;
	
	public Animal() {
		super();
	}
	
	public Animal(int numberOfEyes, boolean terrestrial, int age, boolean alive) {
		this.numberOfEyes = numberOfEyes;
		this.terrestrial = terrestrial; 
		this.age = age;
		this.alive = alive;
	}
	
	public int getNumberOfEyes() {
		return numberOfEyes;
	}

	public void setNumberOfEyes(int numberOfEyes) {
		this.numberOfEyes = numberOfEyes;
	}

	public boolean isTerrestrial() {
		return terrestrial;
	}

	public void setTerrestrial(boolean terrestrial) {
		this.terrestrial = terrestrial;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public abstract void makeNoise();
}
