package questions;

//Q3Reverse contains method reverseString(String input)
//which will return the reverse of String input.
public class Q3ReverseString {
	
	public String reverseString(String input) {
		//String reverse will return the reverse of String input
		String reverse = "";
		int n = input.length();
		//for loop beginning from the last index
		//of String input
		for(int i = n - 1; i >= 0; i--) {
			//reverse concatenates the character at each index of input,
			//which at the end of the loop will be the reversed String of input.
			reverse += Character.toString(input.charAt(i));
		}
		//Reversed String is now returned
		return reverse;
	}
}
