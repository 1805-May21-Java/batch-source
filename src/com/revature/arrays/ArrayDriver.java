package com.revature.arrays;

import java.util.Arrays;

public class ArrayDriver {
    public static void main(String args[]){
        //Example code
        int[] intArray1 = new int[5];
        int intArray2[]= new int[5];
        int[] intArray3 = {3, 0, 7, 7, 8};

        //example output.
        //Changing 0 or 1 to any value above 4 will
        //return an ArrayIndexOutOfBoundsException.
        System.out.println(intArray3[0]);
        System.out.println(intArray3[1]);

        //Prints blah array out as a string.
        System.out.println(Arrays.toString(intArray3));

        //Finds the location of the given whatever.
        System.out.println(Arrays.binarySearch(intArray3,7));

        /* ******************************************************************
        Two-Dimensional Arrays are pretty nifty. Let's make (an) example(s).
         ****************************************************************** */

        int[][]arrayOf2Dims = new int[2][4];
        int arrayOf2Dims2[][] = new int[2][4];
        int[] arrayOf2Dims3[] = new int[2][4];
        int[][] arrayOf2Dims4 = {{1,4,5,6},{9,3,6,3}};

        
    }
}
