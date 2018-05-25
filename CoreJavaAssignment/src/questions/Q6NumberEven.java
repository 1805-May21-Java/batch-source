package questions;

//Program contains method isNumberEven(int number) which checks if number is
//even and returns a boolean.
public class Q6NumberEven {
	
	//method checks for even by dividing number by 2
	public boolean isNumberEven(int number) {
		//divided stores result of number/2
		int divided = number / 2;
		//checks if number is even by comparing division
		//result, and returning true if its, else it
		//returns false.
		if(number == (divided * 2)) {
			return true;
		}
		return false;
	}

}
