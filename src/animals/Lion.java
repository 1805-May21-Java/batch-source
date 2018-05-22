package animals;

/*
 * Inheritance
 * - Lion inherited from Mammal class
 * 
 * Encapsulation
 *  - The Lion class member variables are made private, allows Lion to read and write through use of its methods.
 *  
 *  Polymorphism
 *   - Overriden superclass's eatNow method.
 */

public class Lion extends Mammal{
	//Member variables access limited to only the Lion class
	private boolean goHunting;
	private boolean growlLoudly;
	
	//Constructor adopts superclass constructor
	public Lion() {
		super();
	}
	
	public Lion(int walkingSpeed, boolean eating, boolean sleeping, boolean goHunting, boolean growlLoudly) {
		super(walkingSpeed, eating, sleeping);
		this.goHunting = goHunting;
		this.growlLoudly = growlLoudly;
	}
	
	
	//Getter and Setter for Lion's private variables
	public boolean isGoHunting() {
		return goHunting;
	}

	public void setGoHunting(boolean goHunting) {
		this.goHunting = goHunting;
	}

	public boolean isGrowlLoudly() {
		return growlLoudly;
	}

	public void setGrowlLoudly(boolean growlLoudly) {
		this.growlLoudly = growlLoudly;
	}

	
	public void huntFaster(int fasterPace) {
		this.walkingSpeed += fasterPace;
		System.out.println("Lion will now hunt at a pace of " + this.walkingSpeed);
	}

	
	public void intimidatePrey() {
		if(this.growlLoudly == true) {
			System.out.println("Lion is already intimidating the prey.");
		}else {
			this.growlLoudly = true;
		}
	}
	
	//Example of polymorphism, overrides parent class method
	@Override
	public void eatNow() {
		System.out.println("Will Lion eat or not eat?");
		super.eatNow();
	}
	
	
	
	
}