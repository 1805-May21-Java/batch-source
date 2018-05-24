package com.revature.algorithms;

public class Even {

	private int[] arr;
	
	public Even() {
		super();
		arr = new int[100];
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	public void fillArr(int n) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}
	
	public void printEvens() {
		System.out.print("[");
		for(int i : arr) {
			if(i % 2 == 0) {
				if(i > 2)
					System.out.print(", ");
				System.out.print(i);
			}
		}
		System.out.println("]");
	}
}
