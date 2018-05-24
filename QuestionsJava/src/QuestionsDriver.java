import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuestionsDriver {

	private static Random random = new Random();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<String> questions = new ArrayList<String>();
		ArrayList<String> associates = new ArrayList<String>();
		
		BufferedReader br = null;
		String path = "src/data.txt";
		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			line = br.readLine(); // skip "Names"
			
			while (!line.equals("Questions")) {
				associates.add(line);
				line = br.readLine();
			}
			line = br.readLine(); // skip "Questions"
			while (line != null) {
				questions.add(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
//		questions.add("what's the JDK?");
//		questions.add("what is reflection?");
//		questions.add("what are the important interfaces in the collections framework?");
//		
//		associates.add("Mary");
//		associates.add("Paul");
//		associates.add("Jenna");
		
		display(questions, associates);

	}
	
	public static String getRandom(ArrayList<String> arr) {
		int index = random.nextInt(arr.size());
		return arr.get(index);
	}
	
	public static void display(ArrayList<String> q, ArrayList<String> a) {
		System.out.println("Press '1' to display next question or '2' to quit: ");
		String option = sc.nextLine();
		
		switch (option) {
		case "1":
			// display question
			System.out.println(getRandom(a) + ", " + getRandom(q));
			display(q, a);
			break;
		case "2":
			// quit
			System.out.println("Bye.");
			//sc.close();
			break;
		default:
			System.out.println("Invalid option. Please enter '1' to continue or '2' to quit: ");
			display(q, a);
		}
		
	}

}
