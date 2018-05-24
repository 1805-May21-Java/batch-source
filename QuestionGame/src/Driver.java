import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver {
public static LinkedList<Question> getQuestions(String path) {
	LinkedList<Question> questionList = new LinkedList<Question>();

		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);) {
			while ( true ) {
				String question = br.readLine();
				if ( question == null ) {
					break;
				}
				
				String answer = br.readLine();
				if ( answer == null ) {
					break;
				}
							
				questionList.add(new Question(question,answer));
			}
		} catch(IOException e ) {
			return null;
		}

		return questionList;
	}
	
	public static LinkedList<Associate> getContestants(String path ) {
		LinkedList<Associate> associateList = new LinkedList<Associate>();
		
		try (FileReader fr = new FileReader(path);BufferedReader br = new BufferedReader(fr)) {
			while ( true ) {
				String name = br.readLine();
				if ( name == null ) {
					break;
				}
				String score = br.readLine();
				if ( score == null ) {
					break;
				}
				
				int iscore = Integer.parseInt(score);
				
				associateList.add(new Associate(name,iscore));
			}
		} catch( IOException e ) {
			return null;
		}
		
		return associateList;
	}

	public static String getAnswer(Scanner sc) {
		return sc.nextLine();
	}

	public static void askQuestion(Associate a, String question) {
		System.out.println(a + ": " + question);
	}

	public static <T> LinkedList<T> randomize(LinkedList<T> list) {
		LinkedList<T> newList = new LinkedList<T>();

		int n = list.size();
		for (int i = 0; i < n; i++) {
			int index = (int) (Math.random() * 100) % list.size();
			newList.add(list.get(index));
			list.remove(index);
		}

		return newList;
	}

	public static void main(String[] args) {
		LinkedList<Associate> associateList = new LinkedList<Associate>();
		LinkedList<Question> questionList = null;

		// questionList.add("What is a jdk?");
		// questionList.add("What is an interface?");
		// questionList.add("What is multi-threading?");
		// questionList.add("What is reflection?");
		// questionList.add("What modifier is not serialized in an object?");
		// questionList.add("What is git command for putting local commits in the remote
		// repositroy?");

//		associateList.add(new Associate("Thomas", 0));
//		associateList.add(new Associate("Charles", 0));
//		associateList.add(new Associate("Oliver", 0));
//		associateList.add(new Associate("Harris", 0));
//		associateList.add(new Associate("Jay", 0));
		
		String associatePath = "./associates";
		String questionPath = "./questions";
		
		associateList = getContestants(associatePath);
		if ( associateList == null ) {
			System.out.println("There was an error reading in the associates");
			return;
		}
		
		questionList = getQuestions(questionPath);
		
		if ( questionList == null ) {
			System.out.println("There was an error reading in questions");
			return;
		}

		// Read in or write out associates and questions

		associateList = randomize(associateList);
		questionList = randomize(questionList);

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < associateList.size(); i++) {
			Associate a = associateList.get(i);
			Question q = questionList.get(i);
			askQuestion(a, q.getQuestion());
			String str = getAnswer(sc);
			
			if ( str.compareToIgnoreCase(q.getAnswer()) == 0 ) {
				System.out.println("Correct!");
			}
		}
	}
}
