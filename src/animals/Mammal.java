package animals;

public class Mammal implements Animal{ //Abstraction
	//Mammal specific qualities
	protected int numLegs;
	protected int weightinKilo;
	protected int heightInCentimeter;

	//generate constructors superclass and field
	public Mammal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mammal(int numLegs, int weightinKilo, int heightInCentimeter) {
		super();
		this.numLegs = numLegs;
		this.weightinKilo = weightinKilo;
		this.heightInCentimeter = heightInCentimeter;
	}

	//change them into concrete methods for subclasses to use
	@Override
	public void makeNoise() {
	}
	
	@Override
	public void lifeExpectancy() {	
	}

	//Encapsulation
	//getter and setter method
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}

	public int getWeightinKilo() {
		return weightinKilo;
	}
	public void setWeightinKilo(int weightinKilo) {
		this.weightinKilo = weightinKilo;
	}

	public int getHeightInCentimeter() {
		return heightInCentimeter;
	}
	public void setHeightInCentimeter(int heightInCentimeter) {
		this.heightInCentimeter = heightInCentimeter;
	}
	
	//used for override polymorphism
	public void staticMethod() {
		System.out.println("This is a Mammal Method");
	}
	
}
