package com.revature.OOps;

public class Cat extends Animal{
   int height;

public Cat() { // default constructor from cat class
	super();
	// TODO Auto-generated constructor stub
}

public Cat(String color, int age, String name, int noOfLegs) { // invoking Animal class constructor
	super(color, age, name, noOfLegs);
	// TODO Auto-generated constructor stub
}

public Cat(int height) { // parameterized constructor from the cat class data member
	super();
	this.height = height;
}
// polymorphism overriding 
@Override
public void eat() {
	System.out.println("cat is eating .......");
	
}
 public void heightInches(int height) {
System.out.println("Height of my cat is  " + height);

}
}