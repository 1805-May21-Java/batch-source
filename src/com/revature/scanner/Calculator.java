package com.revature.scanner;

import java.io.LineNumberInputStream;
import java.util.Scanner;

public class Calculator {

    private static Scanner scanner = new Scanner(System.in);

    public void calculate(){

        System.out.println("Please enter the operation you'd like to perform: ");
        String op = scanner.nextLine();
        System.out.println(op);

        int[]nums = new int[0];
        int result=0;

        switch(op){
            case("+"):
                nums = getNums();
                result = nums[0]+nums[1];
                System.out.println("Your result is: "+result);
                break;
            case("-"):
                nums = getNums();
                result = nums[0]-nums[1];
                System.out.println("Your result is: "+result);
                break;
            case("/"):
                nums = getNums();
                if (nums[1] == 0) {
                    result = nums[0] + nums[1];
                } else {
                    System.out.println("Input invalid, cannot divide by 0.");
                }
                System.out.println("Your result is: "+result);
                break;
            case("*"):
                nums = getNums();
                result = nums[0]*nums[1];
                System.out.println("Your result is: "+result);
                break;
            default:
                System.out.println("Invalid Command.");
                calculate();
        }
    }
    private static int[] getNums(){
        int[] nums = new int[2];

        System.out.println("Please enter first number: ");
        nums[0] = getNum();

        System.out.println("Please enter second number: ");
        nums[1] = getNum();

        return nums;
    }
    private static int getNum(){
        int num = 0;
        try {
            num = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException n){
            System.out.println("Invalid.");
        }
        return num;
    }
}
