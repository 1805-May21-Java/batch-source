package questions;

public class Q1BubbleSort {
	
	//Takes in an int[] array as an input
	public int[] bubbleSort(int[] a) {
		//first foor loop swaps elements
		//between a[index] and a[index + 1]
		//iterates to the second to last index in the array
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i+1]) {
				int temp = a[i+1];
				a[i+1] = a[i];
				a[i] = temp;
			}
		}
		
		//Second loop checks for sorted array
		//If array is still unsorted, bubbleSort(a)
		// is called again until entire array is completely sorted
		for(int j = 0; j < a.length - 1; j++) {
			if(a[j] > a[j+1]) {
				bubbleSort(a);
			}
		}
		
		//Sorted array a is then returned
		return a;
	}

}
