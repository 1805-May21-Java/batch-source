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
		this.milkable = true;
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
	
	public void milkAnimal(boolean milkable) {
		if(this.milkable == true) {
			System.out.println("All your animals are milked go make some cheese!");
		}
		if(this.milkable == false) {
			System.out.println("Your animals can be milked if you weren't aware");
		}
	}
	
	public void loveAnimal(boolean loved) {
		if(this.loved == false) {
			System.out.println("Your animals are not petted and thus unloved terrible");
		}
		if(this.loved == true) {
			System.out.println("Your animals are petted and thus feel loved top teir owner");
		}
	}
	public void buyAnimals(int purchased) {
		this.currentOwned += purchased;
		System.out.println("You have more animals! You bought: " +purchased);
		System.out.println("You now have: " +purchased+ " animals");
	}
	
	public void buyAnimals(int goatsPurchased, int cowPurchased){
		
	}
	
	public void canSell(int amount) {
		if(this.currentOwned - amount < 1){
			try {
				throw new SellException("You can't sell animals you don't have");			
						} catch(SellException e) {
				e.printStackTrace();
			}
		}
		this.currentOwned -= amount;
		System.out.println("You have sold your " +amount+ " animals Ca-Ching!");
		System.out.println("You have " +currentOwned+ " animals left");
	}

}
