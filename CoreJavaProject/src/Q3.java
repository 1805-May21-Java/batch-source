public class Q3 {
	//Will store the reversed string 
	static StringBuilder revString = new StringBuilder();
	public static void main(String[] args) {
		
		reverseString("Hello!");
		System.out.println(revString);
	}
	
	//this method reverses the string by appending the last char to revString, then giving the reverseString method
	//the string up until that last char recursively
	private static void reverseString(String string) {
		int length = string.length();
		if(string.length() >= 1) {
			revString.append(string.substring(length-1, length));
			reverseString(string.substring(0,length-1));
			
		}
	}
}
