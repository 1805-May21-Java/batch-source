package com.revature.Animal;

//Goat is inheriting the values and 
public class Goat extends Animal {
	private final int numOfEyes = 2;
	private final int numOfLegs = 4;
	public boolean canClimb;
	public boolean isCanClimb() {
		return canClimb;
	}
	public void setCanClimb(boolean canClimb) {
		this.canClimb = canClimb;
	}
	public int getNumOfEyes() {
		return numOfEyes;
	}
	public int getNumOfLegs() {
		return numOfLegs;
	}
	public Goat(boolean canClimb) {
		super();
		this.canClimb = canClimb;
	}
	public Goat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void buyAnimals(int purchased) {
		this.currentOwned += purchased;
		System.out.println("You have more Goats! You bought: " +purchased);
		System.out.println("You now have: " +purchased+ " Goats");
	}
	
	@Override
	public void buyAnimals(int goatsPurchased, int cowPurchased){
		System.out.println("You Have bought "+goatsPurchased+" Goats, and also " +cowPurchased+ " cows!");
		this.currentOwned = this.currentOwned + goatsPurchased + cowPurchased;
		System.out.println("You now have " +this.currentOwned+ " Goats Total");
	}
	
	@Override
	public void canSell(int amount) {
		if(this.currentOwned -amount <1) {
			try {
				//SellException is taking advantage of Abstraction and Encapsulation at the same time by both hiding the actual exception
				//and summoning it in a separate class, and function
				throw new SellException("You can't sell animals you don't have!");
			} catch(SellException e){
				e.printStackTrace();
			}
		}
		this.currentOwned -= amount;
		System.out.println("You have sold your " +amount+ " animals Ca-Ching!");
		System.out.println("You have " +currentOwned+ " animals left");
	}
	
}
