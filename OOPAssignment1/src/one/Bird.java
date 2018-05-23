package one;
// Bird class extending Animal is an example of Inheritance 
public class Bird extends Animal {

	// Because Bird extends Animal, it must have properties numOfLegs and skinType (Inheritance)
	int numOfLegs = 2;
	String skinType = "feathers";

	// Because Bird extends Animal, Bird must contain a move() method (Inheritance)
	// Overriding the move method below with a command different from its parent class
	// is an example of Polymorphism 
	public void move() {
		System.out.println("The Bird flies away!");
	}

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
		
		if (this.numOfLegs < 0) {
			try {
				throw new NegativeLegsException("Animals cannot have a negative number of legs");
			} catch (NegativeLegsException e) {
				e.printStackTrace();
			}
		}
	}
}
