package core_java_assignment;

import java.util.ArrayList;

public class Question13 {
	private int startValue = 0;
	private ArrayList<String> printArray = new ArrayList();
	public void triangle (int size) {
		for (int i = 1; i <= size; i++) {
			printArray.clear();
			if(i%2 == 0) {
				startValue = 1;
			} else startValue = 0;
			for (int j = 0; j < i; j++) {
				if(printArray.size() == 0) {
					printArray.add(startValue + " ");	
				} else {
					if(startValue == 0) {
						startValue = 1;
					} else {
						startValue = 0;
					}
					printArray.add(startValue + " ");
				}
				
			}
			System.out.println(printArray);
		}
	}
}
