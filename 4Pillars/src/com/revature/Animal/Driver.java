//Author: Keandre Palmer
package com.revature.Animal;

public class Driver {
	public static void main(String[] args) {
		
		//Intialized new Animal object called a1
		Animal a1 = new Animal();
		Cow c1 = new Cow();
		
		//a1 is runnning the buyAnimals class with a int 15 parameter
		a1.buyAnimals(15);
		
		//a1 is running the canSell class with an int 7 parameter
		a1.canSell(7);
		
		//a1 is running the 2nd canSell class by taking advantage of Polymorphism
		a1.buyAnimals(11, 12);
		
		c1.buyAnimals(32);
		c1.canSell(15);
		
	}

}
