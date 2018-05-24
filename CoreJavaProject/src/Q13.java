
public class Q13 {

	public static void main(String[] args) {

		//Reading from the right starting at 1, 
		//the odd indexed numbers are 1's, the evens are 0.
		//Because I can't print right to left, I have to do a fancy thing to make it even/odd equivalent 
		//and add i and j
		for(int i = 1;i<5;i++) {
			for(int j = 4; j>=5-i;j--) {
				//Because j starts at 4 and goes down, to make it work
				//I subtract j from 4, so 4-j goes 0,1,2,3
				System.out.print(isOdd(4-j)+" ");
			}
			System.out.println();
		}
	}
	
	//returns 0 if even, 1 if odd
	private static int isOdd(int num) {
		return (num % 2 == 0 ? 0 : 1);
	}

}
