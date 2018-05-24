
public class Q12 {

	public static void main(String[] args) {
		//creates the array
		int[] array = new int[100];
		for(int i =1;i<101;i++) {
			array[i-1] = i;
		}
		for(int j : array) {
			//tests if even using modular arithmetic
			if(j%2 == 0) {
				//if in here, j is even
				System.out.println(j);
			}
		}
		
	}

}
