package core_java_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question20 {
	private ArrayList<String> firstName, lastName, age, state;
	private Scanner scanner;
	private String[] details;
	private ArrayList<String> list = new ArrayList();
	public void readFile() {
		firstName = new ArrayList();
		lastName = new ArrayList();
		age = new ArrayList();
		state = new ArrayList();
		String dir = System.getProperty("user.dir");
		File file = new File(dir+"/bin/core_java_assignment/data.txt");
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			details = scanner.nextLine().split(":");
			firstName.add(details[0]);
			lastName.add(details[1]);
			age.add(details[2]);
			state.add(details[3]);
		}
		for(int i = 0; i< firstName.size(); i++) {
			System.out.println("Name: " + firstName.get(i) +" " + lastName.get(i));
			System.out.println("Age: " + age.get(i) + " Years");
			System.out.println("State: " + state.get(i) + " State\n");
		}
	}

}
