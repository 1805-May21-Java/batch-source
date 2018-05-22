package animals;
import exceptions.EatingException;

/*
 * Abstraction:
 *  - Class Mammal implements interface Animal, overriding provided abstract methods for more concrete methods.
 * 
 * Inheritance:
 *  - Class Mammal serves as the superclass for classes Lion and Cow.
 * 
 * Encapsulation:
 *  - Member variables are given the protected access modifier to hide data from everything but itself and its subclasses.
 *  - In addition the getter and setters are included to restrict access and view of the data
 *  to its class methods.
 *  
 *  Polymorphism:
 *   - Methods from Animal are overriden.
 *   
 *  Custom Exception is included in method eatNow(), which will be inherited by the subclasses.
 *   
 */

public class Mammal implements Animal{
	//An example of encapsulation, restricts data accessibility to
	//class and subclasses
	protected int walkingSpeed;
	protected boolean eating;
	protected boolean sleeping;
	
	public Mammal() {};
	
	public Mammal(int walkingSpeed, boolean eating, boolean sleeping) {
		this.walkingSpeed = walkingSpeed;
		this.eating = eating;
		this.sleeping = sleeping;
	}
	
	
	//Getter and Setters for Mammal class member variables
	//Achieve encapsulation by restricting data access and
	//Only allowing its class methods to read and write to member variables
	public int getWalkingSpeed() {
		return walkingSpeed;
	}

	public void setWalkingSpeed(int walkingSpeed) {
		this.walkingSpeed = walkingSpeed;
	}

	public boolean isEating() {
		return eating;
	}

	public void setEating(boolean eating) {
		this.eating = eating;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}


	//Instance of Polymorhism, overrides abstract method from the Animal interface,
	//allows for a more concrete method.
	@Override
	public void eatNow() {
		try {
			if(this.eating == true) {
				throw new EatingException("Already Eating");
			}else {
				this.eating = true;
				System.out.println("Begin eating...");
			}
		}catch(EatingException e) {
			System.out.println(e.getMessage());
		}
	}

	//Another instance of polymorphism
	@Override
	public void walkFaster(int increment) {
		this.walkingSpeed += increment;
		System.out.println("Pace has increased to " + this.walkingSpeed);
	}
	
	
	
}