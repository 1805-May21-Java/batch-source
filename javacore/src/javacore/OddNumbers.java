package javacore;

import java.util.ArrayList;

public class OddNumbers {
	public static boolean isPrime(int n) {
	    // Test even factors first
	    if(n > 2 && (n & 1) == 0)
	       return false;
	    //now test odd
	    for(int i = 3; i * i <= n; i += 2)
	        if (n % i == 0) 
	            return false;
	    return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arrayNums = new ArrayList<Integer>();
			
			for(int i = 0; i<=100;i++) {
				arrayNums.add(i);
				if(isPrime(i)) {
					System.out.println(arrayNums.get(i));
				}
				
			}
			
			
	}

}
