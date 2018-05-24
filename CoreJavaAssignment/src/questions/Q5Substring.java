package questions;

public class Q5Substring {
	public String getSubstring(String str, int idx) {
		String sub = "";
		for(int i = 0; i < idx; i++) {
			sub += Character.toString(str.charAt(i));
		}
		
		return sub;
	}
}
