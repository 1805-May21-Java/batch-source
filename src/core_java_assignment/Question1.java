package core_java_assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Question1 {
	//1,0,5,6,3,2,3,7,9,8,4
	private ArrayList<Integer> list = new ArrayList(Arrays.asList(1,0,5,6,3,2,3,7,9,8,4));
	
	public ArrayList<Integer> bubbleSort(){
		for(int i = 0; i < list.size() - 1; i++){
			for(int j = 0; j < list.size() - 1; j++){
				if(list.get(j) > list.get(j+1)){
					int swap = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, swap);
				}
			}
		}
		return list;
	}
}
