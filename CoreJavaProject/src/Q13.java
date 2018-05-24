
public class Q13 {

	public static void main(String[] args) {

		//Reading from the right, the odd indexed numbers are 0's, the evens are 1.
		//Because I can't print right to left, I have to do a fancy thing to make it even/odd equivalent 
		//and add i and j
		for(int i = 1;i<5;i++) {
			for(int j = 4; j>=5-i;j--) {
				System.out.print(isOdd(j+i)+" ");
			}
			System.out.println();
		}
	}
	
	//returns 1 if even, 0 if odd
	private static int isOdd(int num) {
		return (num % 2 == 0 ? 1 : 0);
	}

}
