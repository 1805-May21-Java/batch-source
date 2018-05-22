package animals;

public class Driver{
	public static void main(String[] args) {
		Mammal m1 = new Mammal();
		m1.setEating(true);
		m1.eatNow();
		m1.setSleeping(true);
		System.out.println(m1.isSleeping());
		
		Cow c1 = new Cow();
		c1.eatNow();
		c1.setEating(true);
		c1.eatNow();
		c1.milkTheCow();
		c1.setMilkCow(true);
		c1.milkTheCow();
		
		Lion l1 = new Lion();
		l1.setEating(true);
		l1.eatNow();
		l1.walkFaster(56);
		l1.huntFaster(64);
		
		Dog d1 = new Dog();
		d1.setEating(true);
		d1.eatNow();
		d1.makeNoise();
		d1.makeNoise(true);
		d1.makeNoise();
		d1.walkFaster(89);
		
		//Example of polymorphism via upcasting from subclass to superclass
		Mammal m2 = new Cow();
		m2.eatNow();
	}
}