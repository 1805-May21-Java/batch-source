
public class BubbleSortDriver {
	
	public static void main(String args[]) {
		
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4}; // array to be sorted
		arr = bubbleSort(arr);
		printArray(arr);
	
	}
	
	public static int[] bubbleSort(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			for (int j=0; j<arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void printArray(int[] arr) {
		System.out.println("Array sorted with BubbleSort:");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	

}
