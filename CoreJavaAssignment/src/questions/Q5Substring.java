package questions;

//Program contains method getSubtring(String str, int idx) which returns
//the substring of all characters between 0 and idx - 1
public class Q5Substring {
	
	public String getSubstring(String str, int idx) {
		//String sub will contain the subString of str.
		String sub = "";
		//for loop beginning at 0 and up to idx - 1
		for(int i = 0; i < idx; i++) {
			//sub concatenates each character at str index at i.
			sub += Character.toString(str.charAt(i));
		}
		//sub now contains substring of str and returns.
		return sub;
	}
}
