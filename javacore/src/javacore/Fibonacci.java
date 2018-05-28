package javacore;

public class Fibonacci {
	 static int fib(int a) {
		 
		 if(a == 0) return 0;
		 if(a == 1) return 1;
		 
		
		 
		 return fib(a - 1) + fib(a - 2);
		 
	}
	 
	 public static void main(String[] args) {
		 
		 for(int i = 0; i < 26; i++) {
			 System.out.println(fib(i)); 
		 }
		
		 
	}
}
