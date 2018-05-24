package core_java_assignment;

public class Question3 {

	public String reverseString(String string){
		StringBuffer reverseString = new StringBuffer(string);
		int length = string.length();
		for(int i = length - 1; i >= 0; i--){
			reverseString.append(reverseString.charAt(i));
		}
		return reverseString.substring(length);
	}
}
