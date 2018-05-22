package animals;

/*
 * Inherits from Mammal class, overrides superclass's eatNow method.
 * Getter and Setter from member variable has been created as well.
 */

public class Cow extends Mammal{
	//Encapsulates data by limiting access to only its class
	private boolean milkCow;
	
	//Example of inheritance, using the parent class's constructor in
	//place of its own.
	public Cow() {
		super();
	}

	public Cow(int walkingSpeed, boolean eating, boolean sleeping) {
		super(walkingSpeed, eating, sleeping);
	}
	
	public Cow(boolean milkCow) {
		super();
		this.milkCow = milkCow;
	}
	
	//Getter and setter for member variable(Encapsulation)
	public boolean isMilkCow() {
		return milkCow;
	}

	public void setMilkCow(boolean milkCow) {
		this.milkCow = milkCow;
	}
	
	//Polymorphism example
	@Override
	public void eatNow() {
		System.out.println("Will Cow eat or not eat?");
		super.eatNow();
	}
	
	public void milkTheCow() {
		if(milkCow == true) {
			System.out.println("Milking cow");
		}else {
			System.out.println("Cow cannot be milked");
		}
	}
	
	
}