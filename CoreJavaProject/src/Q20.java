import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q20 {

	
	public static void main(String[] args) {

		//reads in the file
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Q20Text.txt"));
			//loops through the lines
			for(String line = bufferedReader.readLine();line != null; line = bufferedReader.readLine()) {
				//initializes the variables for each person
				String firstName;
				String lastName;
				int age;
				String state;
				ArrayList<Integer> colonList = findColons(line);
				//First name is always between the start and the first colon
				firstName = line.substring(0, colonList.get(0));
				//Last name always between the first two colons. Plus 1 gets rid of the colon
				lastName = line.substring(colonList.get(0)+1, colonList.get(1));
				age = Integer.valueOf(line.substring(colonList.get(1)+1, colonList.get(2)));
				//state between last colon and the end
				state = line.substring(colonList.get(2)+1,line.length());
				System.out.println(String.format("Name: %s %s\nAge: %d\nState: %s State", firstName,lastName,age,state));
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//I want to make substrings around every colon, so this method finds the location of all the colons in the string
	static private ArrayList<Integer> findColons(String line) {
		ArrayList<Integer> colonLocation = new ArrayList<>();
		char[] charArr = line.toCharArray();
		//loops through adding the index whenever a colon is found
		for(int i=0;i<charArr.length;i++) {
			if(charArr[i] == ':' ) {
					colonLocation.add(i);
			}
		}
		return colonLocation;
	}

}
