package javacore;

public class BubbleSort {
	
	public static void bubbleSort(int[] a ) {
		int size = a.length;
		for(int i = 0; i < size - 1; i++) {
			for(int j = 0; j < size - 1; j++) {
				if(a[j] > a[j + 1]) {
					 int temp = a[j];
	                    a[j] = a[j+1];
	                    a[j+1] = temp;
				}
				
				
			}
		}
	}
	

	
	public static void main(String[] args) {
		int[] arr = {2,6,1,0,3,11,6};
		
		bubbleSort(arr);
		
		if(arr.length >= 1) {
			System.out.print(arr[0]);
		}
		
		for(int i = 1; i<arr.length;i++) {
			System.out.print( ", " + arr[i] );
		}
	}
}
