package animals;

public class Rattlesnake extends Reptile{ //Inheritance
	private int lengthinCM;
	
	//generate constructor and superclass
	public Rattlesnake(int lengthinCM) {
		super();
		this.lengthinCM = lengthinCM;
	}

	public Rattlesnake() {
		super();
		this.isPoisonous = true;
		// TODO Auto-generated constructor stub
	}

	//concrete methods coming from Animal class
	public void makeNoise() {
		System.out.println("Hissssss");
	}
	public void lifeExpectancy() {
		System.out.println("20 to 30 years." );
	}
	
	//Encapsulation, getter and setter
	public int getLengthinCM() {
		return lengthinCM;
	}
	public void setLengthinCM(int lengthinCM) {
		this.lengthinCM = lengthinCM;
	}
	
	//override polymorphism
	public void staticMethod() {
		System.out.println("This is a Rattlesnake Method");
	}
	
}
