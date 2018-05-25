package questions;

import java.util.ArrayList;

//Q19ArrayList gives the sum of Evens and sum of Odds in an ArrayList with
//values 1 to 10. The list is then modified by removing the prime numbers and printed.
public class Q19ArrayList {
	
	public static void main(String[] args) {
		//arrList is created and populated with values between 1 to 10
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			arrList.add(i + 1);
		}
		System.out.println("ArrayList at start of program.");
		System.out.println(arrList);
		
		int sumEvens = 0;
		int sumOdds = 0;
		//enhanced for loop checks number is even, then it adds its value to
		//sumEvens, else it adds its value to sumOdds.
		for(Integer number : arrList) {
			if(number % 2 == 0) {
				sumEvens += number;
			}else {
				sumOdds += number;
			}
		}
		
		System.out.println("Sum of evens is: " + sumEvens);
		System.out.println("Sum of odds is: " + sumOdds);

		//Q9 helper method is used to find prime numbers
		//Q9ArrayPrimes object created and called in subsequent for loop.
		Q9ArrayPrimes q9Helper = new Q9ArrayPrimes();
		//ArrayList storePrimes will store primes found in for loop below.
		//If value at arrList index is prime, it is added to storePrimes
		ArrayList<Integer> storePrimes = new ArrayList<Integer>();
		for(int k = 0; k < arrList.size(); k++) {
			boolean checkPrime = q9Helper.isPrime(arrList.get(k));
			if(checkPrime) {
				storePrimes.add(arrList.get(k));
			}
		}
		//for loop removes all primes from arrList
		//by removing by Object, not index
		for(Integer number: storePrimes) {
			arrList.remove(number);
		}
		System.out.println("Primes have been removed for the ArrayList.");
		System.out.println(arrList);
		
	}

}
