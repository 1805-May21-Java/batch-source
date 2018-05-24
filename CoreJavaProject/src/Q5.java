import java.util.Arrays;

public class Q5 {

	public static void main(String[] args) {
		
		//prints the arary of chars, which gets printed as a list
		System.out.println(substring("Hello", 2));
	}
	
	//turns the string into an array of chars, creates a new array only up to the specified index, then returns that new array
	private static char[] substring(String str,int index) {
		char[] charList = str.toCharArray();
		return Arrays.copyOfRange(charList, 0, Integer.min(index, charList.length));
	}

}
