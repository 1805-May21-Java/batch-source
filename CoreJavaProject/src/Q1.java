
public class Q1 {

	//initializes array
	static int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
	
	public static void main(String[] args) {
		//loops over the array starting from the second element
		for(int i = 1;i<arr.length;i++) {
			for(int j = i;j>0;j--) {
			//loops from i down, re-ordering the i'th element until it's in the right place
				
				//compares i to the previous element to see which is bigger
				if(arr[j]<arr[j-1]) {
					//if the i'th element is smaller, switch the order of the two
					switchTwoNumbers(j, j-1);
				}else {
					//if it reaches here, the element is in the correct place 
					//and the sort can move on to the next element
					break;
				}
				//If here, we switched the numbers and j decrements to match the new location
			
			}
		}
		
		for(int k : arr) {
			System.out.println(k);
		}
	
	}
	
	static private void switchTwoNumbers(int index1,int index2) {
		//switches the place of two ints in the array
		int tempVar = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tempVar;
	}

}
