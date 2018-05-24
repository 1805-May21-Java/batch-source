package core_java_assignment;

import java.util.ArrayList;

public class Question12 {
	private ArrayList<Integer> list = new ArrayList();
	public void isEven(int end) {
		list.clear();
		for(int i = 1; i <= end; i++) {
			list.add(i);
			if(list.get(i-1)%2 == 0) {
				System.out.println(list.get(i-1));
			}
		}
	}
}
