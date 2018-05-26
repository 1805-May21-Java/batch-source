package com.revature.hw2;

public class q1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[]numArr = {1,0,5,6,3,2,3,7,9,8,4}; 
			
	        for (int x = 0; x < numArr.length-1; x++)
	            for (int y = 0; y < numArr.length-x-1; y++)
	                if (numArr[y] > numArr[y+1])
	                {
	                    // swap temp and arr[i]
	                    int temp = numArr[y];
	                    numArr[y] = numArr[y+1];
	                    numArr[y+1] = temp;
	                }
	        
			for(int x=0; x<numArr.length;x++) {
				System.out.print(numArr[x]+" ");
			}
		}
}
