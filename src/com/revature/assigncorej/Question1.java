package com.revature.assigncorej;

import java.util.Arrays;

public class Question1 {
    public static void main(String args[]){
        //Filled aray with numbers.
        int[] integer = new int[]{1,0,5,6,3,2,3,7,9,8,4};

        //Calls bubbleSort method.
        bubbleSort(integer);
            //Prints sorted output.
            System.out.print(Arrays.toString(integer));
    }
    //Sorts an array based on bubble sort concept.
    static void bubbleSort(int[] integer) {

        //gets length of array and initialized a temporary variable for switching values.
        int l = integer.length;
        int t = 0;

        //Nested for-loop iterates through array.
        //Outer loop makes sure the sort keeps going if the array is unsorted.
        //Inner loop checks each element and swaps them if they're uneven.
        for(int i = 0; i < l; i++){
            for(int j = 1; j < (l -i); j++){

                if(integer[j-1] > integer[j]){
                    t = integer[j-1];
                    integer[j-1] = integer[j];
                    integer[j] = t;

                }

            }
        }

    }
}
