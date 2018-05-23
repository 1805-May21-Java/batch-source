package one;
// Animal is the parent class of Bird, Dog, and Fish. All are examples of Inheritance. 
// Because Animal is the parent class, the below code can serve as a template for creating Animal 
// objects elsewhere in the program like a regular class, and also serves as a template for its 
// child classes declaring the properties and methods each child class must contain.
public class Animal {
	
	// The two properties that all Animals must have: numOfLegs and skinType
	int numOfLegs;
	String skinType;
	
	// The method all animals must have: move() is declared without an implementation. This is 
	// an example of Abstraction, specifically an abstract method, which is declared here, but 
	// overridden and actually implemented elsewhere in the program
	public void move() {
		
	}

	public Animal() {
		super();
		
	}
	
	// Below are the getters and setters for each property in the Animal class. Getters and Setters 
	// are methods used to return and set values for variables. The data in the Animal class is
	// hidden from other classes, so the Getters and Setters below are necessary to access Animal
	// data from another class. Using Getters and Setters in this manner, in conjunction with 
	// access modifiers, is an example of Encapsulation.
	
	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
		
	}

	public String getSkinType() {
		return skinType;
	}

	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}
}
 