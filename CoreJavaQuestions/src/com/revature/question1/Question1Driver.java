package com.revature.question1;

//Question1Driver class definition
public class Question1Driver {

	public Question1Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	//main method that calls the sort algorithm
    public static void main(String[] args) {  
        //initialize the array
    	int arr[] ={1,0,5,6,3,2,3,7,9,8,4};  
         
        //print the array
        System.out.println("Array Before Bubble Sort");  
        for(int i=0; i < arr.length; i++){  
                System.out.print(arr[i] + " ");  
        }  
        
        //create a bubble object and sort
        BubbleSort b = new BubbleSort();
        b.bubbleSort(arr);//sorting array elements using bubble sort  
         
        //print the sorted array
        System.out.println("\nArray After Bubble Sort");  
        for(int i=0; i < arr.length; i++){  
                System.out.print(arr[i] + " ");  
        }  

    }  
}  
	
	
