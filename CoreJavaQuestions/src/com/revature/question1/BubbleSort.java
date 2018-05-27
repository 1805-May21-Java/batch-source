package com.revature.question1;
//class definition for bubble sort
public class BubbleSort {
	//bubbleSort method that takes an int array and sorts is
    static void bubbleSort(int[] arr) {  
    	//initial variables of array length and temp variable
    	int n = arr.length;  
        int temp = 0;
        //looping through array length
         for(int i=0; i < n; i++){  
        	 //loop till n-i, array length, swapping array index positions along the way
                 for(int j=1; j < (n-i); j++){  
                	 //check condition for swap
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                        	  	temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
  
    }  
    
}
