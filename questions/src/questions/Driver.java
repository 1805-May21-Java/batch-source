package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> pList = new ArrayList<String>();
		
		ArrayList<String> qList = new ArrayList<String>();
		
		
		
		pList.add("Mary");
		pList.add("Tom");
		pList.add("Rok");
		pList.add("Claire");
		
		qList.add("What is Reflection");
		qList.add("Will the singularity happen?");
		qList.add("Why should we decentralize and democratize data?");
		qList.add("What's the JDK?");
		
		
		for(int i =0; i<4;i++) {
			for(String p: pList)
			System.out.println(p);
		}
			
	
		
		
		
	
	}
}
