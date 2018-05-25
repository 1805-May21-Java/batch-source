package questions;

//Q9ArrayPrimes contains two methods, the first, printPrimes(int[] array) will print all
//primes in array. The second method, isPrime(int number) is used
//to check if number is prime and is used by printPrimes(int[] array).
public class Q9ArrayPrimes {
	
	public void printPrimes(int[] array) {
		//count is used to keep track of all primes in sequence
		int count = 0;
		//enhanced for loop is used to iterate through the entire array
		for(int i : array) {
			//if checkPrimes is true, the prime is printed.
			boolean checkPrimes = isPrime(i);
			if(checkPrimes) {
				count++;
				System.out.println("Prime " + count + ": " + i);
			}
		}
	}
	
	//This method is used to check for prime numbers.
	public boolean isPrime(int number) {
		//number is checked for remainder using modulus and numbers between
		//2 and (number - 1)
		//if a remainder == 0 and therefore not prime, a false boolean is returned,
		//else its true.
		for(int i = 2; i < number; i++ ) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
