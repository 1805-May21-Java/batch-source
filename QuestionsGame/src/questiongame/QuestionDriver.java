package questiongame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionDriver {
	public static void main(String[] args) {
		//Lists to store the people and the questions
		ArrayList<People> associates = new ArrayList<>();
		ArrayList<Questions> questions = new ArrayList<>();
		//List to store random pairings of people and questions
		ArrayList<PeopleQuestionPair> peopleQuestionPair = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		try(BufferedReader questionReader = new BufferedReader(new FileReader("src/questiongame/Questions.txt"));
			BufferedReader peopleReader = new BufferedReader(new FileReader("src/questiongame/Associates.txt"));) {
			//Creating the list of questions and associates
			
			String lineQuestion = questionReader.readLine();
			while(lineQuestion != null) {
				questions.add(new Questions(lineQuestion));
				lineQuestion = questionReader.readLine();
			}
			String linePeople = peopleReader.readLine();
			while(linePeople != null) {
				associates.add(new People(linePeople));
				linePeople = peopleReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		//Pairs the people and the questions
		for(People person : associates) {
			if(questions.size()>0) {
				//selects a random question from the remaining list
				int randomIndex = (int) (Math.random()*questions.size());
				peopleQuestionPair.add(new PeopleQuestionPair(person,questions.get(randomIndex)));
				//removes that question so there aren't any repeats
				questions.remove(randomIndex);
				
			}
		}
		for(int i=0;i<peopleQuestionPair.size();i++) {
			//Asks if they want a question
			System.out.println("Do you want to ask someone a question?");
			scanner.nextLine();
			System.out.println("It's happening anyway!");
			//print the questions regardless of answer
			System.out.println(peopleQuestionPair.get(i));
		}
		
		System.out.println("Out of questions!  Try again later!");
		scanner.close();
	}
}
