package javacore;

public class TernaryMin {
		static boolean findMin(int x, int y) {
			if((x < y ) ? true:false) {
				System.out.println(x);
				return true;
			} else {
				System.out.println(y);
			}
			return true;
		}
		
		public static void main(String[] args) {
			findMin(0,-4);
		}
}
