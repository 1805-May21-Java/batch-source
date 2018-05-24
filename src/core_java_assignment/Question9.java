package core_java_assignment;

import java.util.ArrayList;

public class Question9 {
	private ArrayList<Integer> list = new ArrayList();
	private ArrayList<Integer> factors = new ArrayList();
	public void prime(){
		list.clear();
		for(int i = 1; i <= 100; i++){
			factors.clear();
			list.add(i);
			for(int j = 0; j < list.size(); j++){
				if(list.get(i - 1)%list.get(j) == 0){
					factors.add(list.get(j));
				}
				if(factors.size() > 2){
					break;
				}
//				System.out.println(factors);
			}
				if(factors.size() <= 2 && list.get(i - 1) != 1){
					System.out.println(list.get(i - 1));
				}
		}
	}
}
