package com.revature.beans;

import com.revature.exceptions.NegativeWeightException;

//I use inheritance to avoid duplicate code with functionality provided in Animal
public class Dog extends Animal 
{
	private String answersTo;
	//I use polymorphism to override the superclass's sound variable to make it a final variable
	final static String SOUND = "WOOF!";
	
	public Dog() 
	{
		super();
	}


	public Dog(String name, int weight, String answersTo) 
	{
		super(name, weight);
		this.answersTo = answersTo;
	}


	public Dog(String answersTo) 
	{
		super();
		this.answersTo = answersTo;
	}

	public String getAnswersTo() {
		return answersTo;
	}


	public void setAnswersTo(String answersTo) {
		this.answersTo = answersTo;
	}

	public void play() 
	{
		System.out.println("Fetch, play dead, or play tug-o-war?");
	}
	
	//I use polymorphism to override the super class's toString to add the animal type, sound, and answers to
	public String toString()
	{
		return "The dog " + this.name + ", answering to " + answersTo + ", weighs " + this.weight + "lb and says " + SOUND;
	}

}
