//Author:Keandre Palmer
//Date: 05/22/2018
//
package com.revature.Animal;

public class Animal {
	private boolean milkable;
	private boolean loved;
	protected int currentOwned;
	
	//default constructor
	public Animal() {
		super();
		this.loved = true;
		// TODO Auto-generated constructor stub
	}

	public Animal(boolean milkable, boolean loved, int currentOwned) {
		super();
		this.milkable = milkable;
		this.loved = loved;
		this.currentOwned = currentOwned;
	}
	
	//Getter for milkable
	public boolean isMilkable() {
		return milkable;
	}
	
	//Setter for milkable
	public void setMilkable(boolean isMilkable) {
		this.milkable = isMilkable;
	}
	
	//Getter for loved
	public boolean isLoved() {
		return loved;
	}
	
	//Setter for milkable
	public void setLoved(boolean isLoved) {
		this.loved = isLoved;
	}
	
	//Getter for currentOwned
	public int getCurrentOwned() {
		return currentOwned;
	}
	
	//Setter for currentOwned
	public void setCurrentOwned(int currentOwned) {
		this.currentOwned = currentOwned;
	}
	
	//Function for checking to see if animals were milked
	public void milkAnimal(boolean milkable) {
		if(this.milkable == true) {
			System.out.println("All your animals are milked go make some cheese!");
		}
		if(this.milkable == false) {
			System.out.println("Your animals can be milked if you weren't aware");
		}
	}
	//Function for checking to see if animals were petted/loved today
	public void loveAnimal(boolean loved) {
		if(this.loved == false) {
			System.out.println("Your animals are not petted and thus unloved terrible");
		}
		if(this.loved == true) {
			System.out.println("Your animals are petted and thus feel loved top teir owner");
		}
	}
	//Buy Animals so you can pet them
	public void buyAnimals(int purchased) {
		this.currentOwned += purchased;
		System.out.println("You have more animals! You bought: " +purchased);
		System.out.println("You now have: " +purchased+ " animals");
	}
	//Buy both Goats and Cows
	public void buyAnimals(int goatsPurchased, int cowPurchased){
		System.out.println("You Have bought "+goatsPurchased+" Goats, and also " +cowPurchased+ " cows!");
		this.currentOwned = this.currentOwned + goatsPurchased + cowPurchased;
		System.out.println("You now have " +this.currentOwned+ " Animals Total");
	}
	//Sell your animals
	public void canSell(int amount) {
		this.currentOwned -= amount;
		System.out.println("You have sold your " +amount+ " animals Ca-Ching!");
		System.out.println("You have " +currentOwned+ " animals left");
	}

}
