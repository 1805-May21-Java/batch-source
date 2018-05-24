package questions;

public class Q9ArrayPrimes {
	
	public void printPrimes(int[] array) {
		int count = 0;
		for(int i : array) {
			boolean checkPrimes = isPrime(i);
			if(checkPrimes) {
				count++;
				System.out.println("Prime " + count + ": " + i);
			}
		}
	}
	
	private boolean isPrime(int number) {
		for(int i = 2; i < number; i++ ) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
