package questions;

//Q15MyClass implements Q15Interface and includes the interface's
//overridden methods
public class Q15MyClass implements Q15Interface{

	//returns addition of a and b
	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	//returns subtractions of a and b
	@Override
	public int subtraction(int a, int b) {
		return a - b;
	}
	
	//returns multiplication of a and b
	@Override
	public int multiplication(int a, int b) {
		return a * b;
	}
	
	//returns division of a and b
	@Override
	public int division(int a, int b) {
		//checks if b is 0. If true then an IllegalArgumentException is thrown
		if(b == 0) {
			throw new IllegalArgumentException();
		}
		return a / b;
	}
	
	

}
