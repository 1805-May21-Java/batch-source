package javacore;

public class EvenNums {
	public static void main(String[] args) {
		int[] hundred = new int[100];
		
		for(int i = 0;i < hundred.length;i++) {
			hundred[i] = i + 1;
		}
		for(int n:hundred) {
			if(n % 2 == 0) {
				System.out.println(n);
			}
		}
	}
}
