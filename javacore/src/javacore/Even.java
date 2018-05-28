package javacore;

public class Even {
	

	
	static boolean isEven(int i) {
		if((i/2)*2 == i) {
			return true;
		}
		else {
			 return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isEven(11));
	}
}
