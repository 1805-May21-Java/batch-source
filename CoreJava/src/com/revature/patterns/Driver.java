package com.revature.patterns;

public class Driver {
	
	public static void main(String[] args) {
		
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
//		Singleton instance = new Singleton();
		System.out.println("instance1's hashcode: "+instance1.hashCode());
		System.out.println("instance2's hashcode: "+instance2.hashCode());
		System.out.println();
		
		instance1.setValue(5);
		System.out.println(instance2.getValue());
		System.out.println();
		
		AnimalFactory af = new AnimalFactory();
		Animal c = af.getAnimal("cat");
		Animal a = af.getAnimal("albatross");
		Animal h = af.getAnimal("hippo");
		c.makeNoise();
		a.makeNoise();
		h.makeNoise();
		
		
	}

}
