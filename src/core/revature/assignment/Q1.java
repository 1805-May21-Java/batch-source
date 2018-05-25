package core.revature.assignment;
//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
public class Q1 {
	void bubbleSort(int array[]) { // void function for the bubble sort
		int n = array.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (array[j] > array[j+1])
				{
					//include a temp variable, swap it with array
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
	}
	void printArray(int array[]) {
		int n = array.length;
		for (int i = 0; i < n; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int array[] = {1,0,5,6,3,2,3,7,9,8,4}; // array
		Q1 bub = new Q1();
		System.out.println("Unsorted array"); // need to show the unsorted array first
		bub.printArray(array);
		bub.bubbleSort(array);
		System.out.println("Bubblesorted array"); // now for the sorted
		bub.printArray(array);
	}
}
