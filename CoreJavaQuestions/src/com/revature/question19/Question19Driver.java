package com.revature.question19;

import java.util.ArrayList;
import java.util.Iterator;

import com.revature.question9.*;

public class Question19Driver {

	public static void main(String[] args) {

		ArrayList<Integer> arrli = new ArrayList<Integer>();
		Question9Driver q9 = new Question9Driver();
        for (int i=1; i<=10; i++) {
            arrli.add(i);
//        	System.out.println(i);        
        }
        
        Iterator<Integer> iterator = arrli.iterator();
        int countOdd = 0, countEven = 0;
        while(iterator.hasNext()){
            int intCheck = iterator.next();
            if ( (intCheck & 1) == 0 ) {
            	countEven+=intCheck;
            } else {
               	countOdd+=intCheck;           	
            }

            
 
            
        }

        System.out.println("Even sum: " + countEven);
        System.out.println("Odd sum: " + countOdd);
        System.out.println("Collection with primes removed: ");
        Iterator<Integer> iterator2 = arrli.iterator();
        while(iterator2.hasNext()){
            int intCheck = iterator2.next();
            if ( q9.isPrime(intCheck) ) {
                System.out.println("removing: "+intCheck);
            	iterator2.remove();
            }        
 
            
        }   
	
        Iterator<Integer> iterator3 = arrli.iterator();
        while(iterator3.hasNext()){
            int intCheck = iterator3.next();
        	System.out.println("arrli value: "+intCheck);      
 
            
        }   
        
	}
}
