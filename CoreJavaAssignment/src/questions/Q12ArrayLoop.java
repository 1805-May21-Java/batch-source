package questions;

//Q12ArrayLoop contains an int[] array, which is then populated with values between
//1 to 100 in the constructor. The method loopEvens() is then used to print
//all even numbers in the array.
public class Q12ArrayLoop {
	private int[] array = new int[100];
	
	//Ensures that array is populated between 1 to 100
	public Q12ArrayLoop() {
		for(int i = 0; i < 100; i++) {
			array[i] = i+1;
		}
	}
	
	//Method uses enhanced for loop to iterate through all elements.
	//Modulus is then used to check for remainder. If remainder is 0, then
	//value is even and printed.
	public void loopEvens() {
		for(int val : array) {
			if(val % 2 == 0) {
				System.out.println(val);
			}
		}
	}

}
