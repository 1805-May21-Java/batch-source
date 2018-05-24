package core_java_assignment;

public class Question5 {
	public String subString(String string, int end){
		StringBuffer subString = new StringBuffer();
		int length = 0;
		if (end > string.length()){
			length = string.length();
		} else {
			length = end;
		}
		for(int i = 0; i < length; i++){
			subString.append(string.charAt(i));
		}
		return subString.toString();
	}
}
