package javacore;

public class Reverse {
	static void reverse(String s) {
		
		for(int i = s.length() -1;i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		reverse("hello");
		reverse("supercalifragilisticexpialidocious");
	}
}
