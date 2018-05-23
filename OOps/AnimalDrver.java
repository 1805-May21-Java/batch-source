package com.revature.OOps;

public class AnimalDrver {

	public static void main(String[] args) {
		
		Animal A = new Animal(); // creating animal object
		A.move();
		A.move(4);
		// creating cat object
		Cat C = new Cat();
		C.eat();
		C.heightInches(6);
	 
		// creating Dog object
		
		Dog D = new Dog();
		D.eat();
		D.move();
		
		// creating snake object
		Snake S = new Snake();
		S.crawl();
		S.isHungry();
		
		// creating Eagle object
		Eagle E = new Eagle();
		E.fly();
		E.makeNoise();
		try {
			throw new MyCustomException();
		}catch(MyCustomException e) {
		
		System.out.println("caught exeception");
		
		
		
	}

}
}