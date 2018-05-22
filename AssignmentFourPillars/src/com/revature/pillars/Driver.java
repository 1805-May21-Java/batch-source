package com.revature.pillars;

import com.revature.animals.*;

public class Driver {

	public static void main(String[] args) {
		/* 
		 * (1) Abstraction
		 * 		focusing on what something does rather what how it does it 
		 * 
		 * 		See: ISpeaks.java in com.revature.interfaces
		 * 
		 * (2) Inheritance
		 * 		the ability for subclasses to adopt the states and behaviors of 
		 * 		their super class
		 * 
		 * 		See: Mouse.java in com.revature.animals
		 * 			 Although Frog.java & Fish.java exist, Mouse.java is where I chose
		 * 			 to explain how these classes represent inheritance.
		 * 
		 * (3) Encapsulation
		 * 		wrapping variables to accomplish data hiding
		 * 
		 * 		See: Animal.java in com.revature.animals
		 * 
		 * (4) Polymorphism
		 * 		flexibility for a class to adapt at compile time or runtime 
		 * 		depending on the conditions
		 * 
		 * 		See: below
		 */
		
		//Normally a class instantiation is done this way
		Mouse m1 = new Mouse("long-haired");
		Frog fr1 = new Frog(8);
		Fish fi1 = new Fish(200);
		
		/*
		 * But polymorphism allows for instantiation against a super class
		 * Here an Animal array is created that contains Mouse, Frog, and Fish 
		 * objects. This is allowed because these classes all extend Animal.
		 */
		Animal[] aArr = {
				new Mouse("short-haired"),
				new Frog(2),
				new Fish(30)
		};
		
		/*
		 * Polymorphism allows for the flexibility shown below, where a general array
		 * can be used to go threw a list of different objects from different classes
		 * 
		 * speak() is a method "required" by the interface that is implemented in the
		 * animal class. This "requirement" is what lets us assume that we can call
		 * speak() on all of these objects.
		 */
		System.out.println("Role call!");
		for (Animal a : aArr) {
			a.speak();
		}
		System.out.println();
		
		
		/*
		 * Unfortunately since aArr[] is defined as just an Animal class, you cannot
		 * call functions tht are unique to a subclass. m1 and aArr[0] are both
		 * instantiated from the mouse class, but since aArr[0] is defined as an
		 * Animal, it can't use describeMe(). The same applies to fr1 and aArr[1], and
		 * fi1 and aArr[2].
		 */
		m1.describeMe();
		//aArr[0].describeMe()
		fr1.rateMySlime();
		//aArr[1].rateMySlime()
		fi1.howScaly();
		//aArr[2].howScaly();
		System.out.println();
		
		/*
		 * Another example of polymorphism is how you can override methods in the parent 
		 * class. speedUp(int) is defined in Animal, but it doesn't add the text. In the 
		 * overriden function I call the super class' definition and then add a system
		 * print to show the method was overriden
		 */
		m1.speedUp(5);
		aArr[0].speedUp(10); //This shows that although aArr[] is defined as an Animal, 
							 //it still uses the Mouse implementation of speedUp(int).
		fr1.speedUp(7);
		fi1.speedUp(110);
		
		
		
		
		//Example for custom exception
//		Animal a1 = new Mouse();
//		a1.setAge(-1); //displays exception message and stack trace
		
	}

}
