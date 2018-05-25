package core.revature.assignment;
//Q11. Write a program that would access two float-variables from a class that exists in another package.
//Note, you will need to create two packages to demonstrate the solution.
import core.revature.Q11Package.*; //import the package 
public class Q11 {
	public static void main(String[] args) {
		Q11Package Q11Class = new Q11Package(); // declare a new class
		System.out.println("Value of public float variable a in Q11Package is " + Q11Class.getA());
		System.out.println("Value of public float variable b in Q11Package is " + Q11Class.getB());
		/*
		 * Note that only public variables are visible.
		 * Default, protected, and private variables cannot be accessed unless you use a getter
		 */
	}
}
