package com.revature.hw1;
// Abstract class is implemented by all classes, since Animal implements makeSound.
// All classes must define makeASound, or be marked as abstract.
public abstract class makeSound {
	public abstract void myAbstractMethod();
	
	public String makeASound(){
		return "Grunt";
	}
}
