package animals;

public class Reptile implements Animal{ //Abstraction
	protected boolean isPoisonous;
	
	//generate constructors superclass and field
	public Reptile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reptile(boolean isPoisonous) {
		super();
		this.isPoisonous = isPoisonous;
	}

	//change them into concrete methods for subclasses to use
	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lifeExpectancy() {
		// TODO Auto-generated method stub
		
	}

	//Encapsulation, getter and setter method
	public boolean isPoisonous() {
		return isPoisonous;
	}
	public void setPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}
	
	//override polymorphism
	public void staticMethod() {
		System.out.println("This is a Reptile Method");
	}
	
}
