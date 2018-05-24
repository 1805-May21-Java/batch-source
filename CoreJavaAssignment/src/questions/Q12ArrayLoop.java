package questions;

public class Q12ArrayLoop {
	private int[] array = new int[100];
	
	public Q12ArrayLoop() {
		for(int i = 0; i < 100; i++) {
			array[i] = i;
		}
	}
	
	public void loopEvens() {
		for(int val : array) {
			if(val % 2 == 0) {
				System.out.println(val);
			}
		}
	}

}
