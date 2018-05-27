package com.revature.assignment;

public class QuestionSix {

	private static int num = 15;
	
	public static void main(String[] args) {
		
		//because java keeps numbers an integer when divided, dividing then multiplying by 2
		//number would equal the original number when even
		if((num/2)*2 == num) {
			System.out.println("Your integer "+num+" is even");
		}else {
			System.out.println("Your integer "+num+" is odd");
		}
	}

}
