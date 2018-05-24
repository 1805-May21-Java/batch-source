package questions;


public class Q1BubbleSort {
	
	public int[] bubbleSort(int[] a) {
		//first loop swaps elements
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i+1]) {
				int temp = a[i+1];
				a[i+1] = a[i];
				a[i] = temp;
			}
		}
		
		//Second loop checks for sorted array
		for(int j = 0; j < a.length - 1; j++) {
			if(a[j] > a[j+1]) {
				bubbleSort(a);
			}
		}
		
		return a;
	}

}
