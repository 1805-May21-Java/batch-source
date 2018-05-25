package core.revature.assignment;
// Q3. Reverse a string without using a temporary variable.
//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
public class Q3 {
	public static void main(String[] args) {
		String in = "Java Question 3"; // here is the string, change it to whatever
		System.out.println("String:");
		System.out.println(in);
		//convert the string into an array of characters, using the toCharArray function
		char[] charArray = in.toCharArray();
		System.out.println("Reversed string: ");
		for (int i = charArray.length-1; i >= 0; i--)
			System.out.print(charArray[i]); // this is the way to reverse the string
	}
}
