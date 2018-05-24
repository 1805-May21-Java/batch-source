package core_java_assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Question2 {
	
	private ArrayList<Integer> list = new ArrayList();
	
	public ArrayList<Integer> fibonacci(int length){
		list.clear();
		list.add(0);
		list.add(1);
		for(int i = 2; i < length; i++){
			if(list.size() == length){
				break;
			}
			list.add(list.get(i-2) + list.get(i - 1));
		}
		System.out.println(list);
		return list;
		
	}
}
