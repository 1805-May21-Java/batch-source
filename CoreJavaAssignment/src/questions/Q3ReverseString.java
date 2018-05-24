package questions;

public class Q3ReverseString {
	
	public String reverseString(String input) {
		String reverse = "";
		int n = input.length();
		for(int i = n - 1; i >= 0; i--) {
			reverse += Character.toString(input.charAt(i));
		}
		
		return reverse;
	}
}
