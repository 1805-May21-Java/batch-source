//Author: Keandre Palmer
package com.revature.Animal;

public class Cow extends Animal{
	private final int numOfUdders = 4;
	protected int spots = 20;
	
	public Cow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cow(int spots) {
		super();
		this.spots = spots;
	}

	public int getSpots() {
		return spots;
	}

	public void setSpots(int spots) {
		this.spots = spots;
	}

	public int getNumOfUdders() {
		return numOfUdders;
	}
	
	@Override
	public void buyAnimals(int purchased) {
		this.currentOwned += purchased;
		System.out.println("You have more cows! You bought: " +purchased);
		System.out.println("You now have: " +purchased+ " cows");
	}
	
	@Override
	public void buyAnimals(int goatsPurchased, int cowPurchased){
		System.out.println("You Have bought "+goatsPurchased+" Goats, and also " +cowPurchased+ " Cows!");
		this.currentOwned = this.currentOwned + goatsPurchased + cowPurchased;
		System.out.println("You now have " +this.currentOwned+ " Animals Total");
	}
	
	@Override
	public void canSell(int amount) {
		if(this.currentOwned -amount <1) {
			try {
				//SellException is taking advantage of Abstraction and Encapsulation at the same time by both hiding the actual exception
				//and summoning it in a separate class, and function
				throw new SellException("You can't sell cows you don't have!");
			} catch(SellException e){
				e.printStackTrace();
			}
		}
		this.currentOwned -= amount;
		System.out.println("You have sold your " +amount+ " animals Ca-Ching!");
		System.out.println("You have " +currentOwned+ " animals left");
	}
}
