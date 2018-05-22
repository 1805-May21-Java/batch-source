package com.revature.hw1;

public class Animal extends makeSound{
	//These will be attributes that all animals have
		protected int numOfLimbs;
		protected int weightCap;
		protected int speedCap;
		protected boolean isMammal;
		//Animal is a child class of Abstract class makeSound.
		public Animal(){
			super();
		}

		public Animal(int numOfLimbs, int weightCap, int speedCap, boolean isMammal) {
			super();
			this.numOfLimbs = numOfLimbs;
			this.weightCap = weightCap;
			this.speedCap = speedCap;
			this.isMammal = isMammal;
		}
		/*Getters and setters for allowing classes to access
		 * the data from hidden variables.*/
		public int getNumOfLimbs() {
			return numOfLimbs;
		}

		public void setNumOfLimbs(int numOfLimbs) {
			this.numOfLimbs = numOfLimbs;
		}

		public int getWeightCap() {
			return weightCap;
		}

		public void setWeightCap(int weightCap) {
			this.weightCap = weightCap;
		}

		public int getSpeedCap() {
			return speedCap;
		}

		public void setSpeedCap(int speedCap) {
			this.speedCap = speedCap;
		}

		public boolean isMammal() {
			return isMammal;
		}

		public void setMammal(boolean isMammal) {
			this.isMammal = isMammal;
		}

		@Override
		public void myAbstractMethod() {
			// TODO Auto-generated method stub
			System.out.println(makeASound());
		}
}