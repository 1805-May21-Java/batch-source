package com.revature.interfaces;

public interface ISpeaks {
	/* 
	 * Represents abstraction in that implementing this interface implies that 
	 * the class has the ability to speak. It's not concerned with how speak is
	 * implemented, it just says that Speak() is an ability of the animal. I
	 * Chose to make this an interface because -- as said in class -- there is
	 * no generic animal noise; so the interface makes sure that the class implements
	 * a sound.
	 */
	void speak();
}
