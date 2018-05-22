package com.revature.hw1;
//Dog is a child class of Animal; inherits all variables of Animal
public class Dog extends Animal{
	//Dog has values that are specific to Dog.
	boolean isTamed;
	boolean doTrick;
	// Dog can change all values inherited from Animal
	@Override
	public int getNumOfLimbs() {
		// TODO Auto-generated method stub
		return super.getNumOfLimbs();
	}

	@Override
	public void setNumOfLimbs(int numOfLimbs) {
		// TODO Auto-generated method stub
		super.setNumOfLimbs(numOfLimbs);
	}

	@Override
	public int getWeightCap() {
		// TODO Auto-generated method stub
		return super.getWeightCap();
	}

	@Override
	public void setWeightCap(int weightCap) {
		// TODO Auto-generated method stub
		super.setWeightCap(weightCap);
	}

	@Override
	public int getSpeedCap() {
		// TODO Auto-generated method stub
		return super.getSpeedCap();
	}

	@Override
	public void setSpeedCap(int speedCap) {
		// TODO Auto-generated method stub
		super.setSpeedCap(speedCap);
	}

	@Override
	public boolean isMammal() {
		// TODO Auto-generated method stub
		return super.isMammal();
	}

	@Override
	public void setMammal(boolean isMammal) {
		// TODO Auto-generated method stub
		super.setMammal(isMammal);
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Dog has defined a unique makeSound.
	public String makeASound(){
		return "Woof!";
	}
	
	public boolean isTamed() {
		return isTamed;
	}

	public void setTamed(boolean isTamed) {
		this.isTamed = isTamed;
	}

	public boolean DoTrick() {
		return doTrick;
	}

	public void setDoTrick(boolean doTrick) {
		this.doTrick = doTrick;
	}

	public Dog(int numOfLimbs, int weightCap, int speedCap, boolean isMammal) {
		super(numOfLimbs, weightCap, speedCap, isMammal);
		// TODO Auto-generated constructor stub
	}
	
}
