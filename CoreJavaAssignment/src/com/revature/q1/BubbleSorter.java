<<<<<<< HEAD
package com.revature.q1;

public class BubbleSorter {

	public BubbleSorter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void bubbleSort(int[] unsortedArr) {

        for(int i = 0; i < unsortedArr.length; i++) {
            for(int j = 0; j < unsortedArr.length; j++) {
                if(unsortedArr[i] < unsortedArr[j]) {
                    int temp = unsortedArr[i];
                    unsortedArr[i] = unsortedArr[j];
                    unsortedArr[j] = temp;
                }
            }
        }

    }
}
=======
package com.revature.q1;

public class BubbleSorter {

	public BubbleSorter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void bubbleSort(int[] unsortedArr) {

        for(int i = 0; i < unsortedArr.length; i++) {
            for(int j = 0; j < unsortedArr.length; j++) {
                if(unsortedArr[i] < unsortedArr[j]) {
                    int temp = unsortedArr[i];
                    unsortedArr[i] = unsortedArr[j];
                    unsortedArr[j] = temp;
                }
            }
        }

    }
}
>>>>>>> 70ec7955e736c9c2ea644fea4703f6f75b046dac
