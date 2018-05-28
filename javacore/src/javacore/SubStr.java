package javacore;

public class SubStr {
	static void subStr(String s, int n) {
		char[] str = s.toCharArray();
		
		for(int i = 0; i < n; i++) {
			System.out.print(str[i]);
		}
	}
	
	public static void main(String[] args) {
		subStr("stophere", 5);
	}
}
