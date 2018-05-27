import java.util.ArrayList;
import java.util.List;

public class Q9 {

	public static void main(String[] args) {
		//creates the arraylist 1-100
		List<Integer> arrayList = new ArrayList<>();
		for(int i = 1;i<101;i++) {
			arrayList.add(i);
		}
		//loops over each, tests if it's prime, and if it is then print it
		(arrayList).forEach(j -> {
			if(isPrime(j)) System.out.println(j);
		});
		
	}
	
	//method that tests if it's prime
	private static boolean isPrime(int num) {
		if(num == 1) {
			//1 is not prime, but will fail the below function
			return false;
		}
		
		for(int i = 2;i<=Math.sqrt((double)num);i++) {
			//checks if the number is divisible by i
			if(num % i == 0) {
				return false;
			}
		}
		//if a number isn't divisible by any number between 2 and the sqrt of itself, it will not have any other divisors
		//besides 1 and itself, and is therefore prime
		return true;
	}

}
