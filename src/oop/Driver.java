package oop;

public class Driver {

	public static void main(String[] args) {

		// Default constructors
		Animal a1 = new Animal();
		Cat c1 = new Cat();
		Lynx l1 = new Lynx();
		
		System.out.println(a1.toString());
		System.out.println(c1.toString());
		System.out.println(l1.toString());
		
		// Test invalid inputs
		l1.setWeight(-2.3);
		
		try {
			l1.setAge(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(l1.getWeight() + ", " + l1.getAge());
		
		// Test setters with valid inputs
		l1.setWeight(18.74);
		
		try {
			l1.setAge(8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		l1.setName("Gilbert");
		l1.setColor("brown");
		System.out.println(l1.toString());
		
		// Overloaded constructors
		Animal a2 = new Animal("John", 16);
		Cat c2 = new Cat("Jones", 3, "white");
		Lynx l2 = new Lynx("Jean", 11, "burgundy", 23.5);
		
		System.out.println(a2.toString());
		System.out.println(c2.toString());
		System.out.println(l2.toString());
		
	}

}
