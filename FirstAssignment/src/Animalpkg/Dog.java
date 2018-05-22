package Animalpkg;

import animalExceptions.negativeLegs;

public class Dog extends Animal { //Inheritence is used by extending Animal class
	//fur color is encapsulated using the private access modifier
	private String furColor; //Dogs have a fur color

	Dog() {
		super();
	}

	Dog(String furColor) {
		super(4); //In general, dogs have 4 legs
		this.furColor = furColor; //Sets fur color
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	
	public void move() { //Defines how a dog moves
		System.out.println("Dog runs");
	}
	
	public static void main( String[] args ) {
		Dog fluffDog = new Dog("Brown");
		Animal fluffy = fluffDog; //Polymorphism allows dog object to be stored as an animal
		
		System.out.println(fluffy.getNumLegs());
		System.out.println(fluffDog.getFurColor());
		
		
		try {
			fluffy.move(); //The dog method is used as opposed to the Animal move method
			fluffy.setNumLegs(-3);
		} catch( negativeLegs e) {
			e.printStackTrace();
		}
	}
}
