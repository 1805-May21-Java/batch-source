package animals;

/*
 * Inheritance:
 *  - Dog inherited from Mammal class.
 *  
 * Encapsulation:
 *  - The Dog class member variables are made private to allow only class Dog to access them
 *  - Getters and Setters are also included for each member variable, which includes
 *  - the member variables inherited from the superclass
 *   
 *   
 */

public class Dog extends Mammal{
	//Encapsulation: 
	//Member variables are private to only allow access to the Dog class
	private String bark = "Happy Bark";
	private boolean goToBathroom;
	private boolean seeCat;
	
	//Constructor uses parent class constructor
	public Dog() {
		super();
	}
	public Dog(int walkingSpeed, boolean eating, boolean sleeping, String bark, boolean goToBathroom, boolean seeCat) {
		super(walkingSpeed, eating, sleeping);
		// TODO Auto-generated constructor stub
		this.bark = bark;
		this.goToBathroom = goToBathroom;
		this.seeCat = seeCat;
	}
	
	//Getters and Setters, to restrict read and write access to these methods.
	public String getBark() {
		return bark;
	}
	public void setBark(String bark) {
		this.bark = bark;
	}
	public boolean isGoToBathroom() {
		return goToBathroom;
	}
	public void setGoToBathroom(boolean goToBathroom) {
		this.goToBathroom = goToBathroom;
	}
	public boolean isSeeCat() {
		return seeCat;
	}
	public void setSeeCat(boolean seeCat) {
		this.seeCat = seeCat;
	}
	
	//Example of polymorphism, overrides superclass method to implement its own.
	@Override
	public void eatNow() {
		System.out.println("Will Dog eat or not eat?");
		super.eatNow();
	}
	
	//Example of polymorphism, method overloading by using the same method name,
	//but with different number of parameters.
	public void makeNoise() {
		System.out.println(this.bark);
	}
	
	public void makeNoise(boolean seeCat) {
		this.seeCat = seeCat;
		if(this.seeCat == true) {
			this.bark = "Angry Bark";
		}else {
			this.bark = "Happy Bark";
		}
		System.out.println(this.bark);
	}
	
	
	
}