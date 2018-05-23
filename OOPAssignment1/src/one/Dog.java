package one;

public class Dog extends Animal {

	// Because Dog extends Animal, it must have properties numOfLegs and skinType (Inheritance)
	int numOfLegs = 4;
	String skinType = "fur";
	
	// Because Dog extends Animal, Bird must contain a move() method (Inheritance)
	// Overriding the move method below with a command different from its parent class
	// is an example of Polymorphism 
	public void move() {
		System.out.println("The Dog runs away!");
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}
}
