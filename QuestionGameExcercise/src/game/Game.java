package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) throws IOException{
		/*
		System.out.println("Game Start!");
		LinkedList<Associate> associateList = new LinkedList<Associate>();
		associateList.add(new Associate("Deku"));
		associateList.add(new Associate("Gintoki"));
		associateList.add(new Associate("Soma"));
		associateList.add(new Associate("Akame"));
		LinkedList<Question> questionList = new LinkedList<Question>();
		questionList.add(new Question("What is programming", "Writing code"));
		questionList.add(new Question("What are the two collection interfaces",
				"Comparator and Comparable"));
		questionList.add(new Question("What is unique about a TreeSet", 
				"It is naturally ordered"));
		questionList.add(new Question("What can a TreeSet not naturally sort", 
				"Objects"));
		
		Collections.shuffle(associateList);
		Collections.shuffle(questionList);
		
		Scanner sc = new Scanner(System.in);
		Iterator<Associate> associates = associateList.iterator();
		Iterator<Question> questions = questionList.iterator();
		
		while(associates.hasNext() && questions.hasNext()) {
			System.out.println("Associate: " + associates.next().getName());
			Question current = questions.next();
			String problem = current.getProblem();
			String ans = current.getAnswer();
			System.out.println("Question: " + problem);
			System.out.println("What is your answer?");
			String yourAnswer = sc.nextLine();
			if(yourAnswer.toLowerCase().compareTo(ans.toLowerCase()) == 0) {
				System.out.println("Answer is correct, 50 points!!!");
			}else {
				System.out.println("Uh oh, wrong answer! But nice try.");
			}
			
		}
		*/
		
		//Uses fileReading with text files
		
		File associateFile = new File("src/game/Associate.txt");
		FileInputStream fiA = new FileInputStream(associateFile);
		BufferedReader brA = new BufferedReader(new InputStreamReader(fiA));
		File questionsFile = new File("src/game/Questions.txt");
		FileInputStream fiQ = new FileInputStream(questionsFile);
		BufferedReader brQ = new BufferedReader(new InputStreamReader(fiQ));
		
		String lineA;
		LinkedList<Associate> associateList = new LinkedList<Associate>();
		LinkedList<Question> questionList = new LinkedList<Question>();
		while((lineA = brA.readLine()) != null){
			Associate currentA = new Associate(lineA);
			String ques = brQ.readLine();
			String ans = brQ.readLine();
			Question currentQ = new Question(ques, ans);
			associateList.add(currentA);
			questionList.add(currentQ);
		}
		
		Collections.shuffle(associateList);
		Collections.shuffle(questionList);
		brA.close();
		brQ.close();
		
		Scanner sc = new Scanner(System.in);
		Iterator<Associate> associates = associateList.iterator();
		Iterator<Question> questions = questionList.iterator();
		
		while(associates.hasNext() && questions.hasNext()) {
			System.out.println("Associate: " + associates.next().getName());
			Question current = questions.next();
			String problem = current.getProblem();
			String ans = current.getAnswer();
			System.out.println("Question: " + problem);
			System.out.println("What is your answer?");
			String yourAnswer = sc.nextLine();
			if(yourAnswer.toLowerCase().compareTo(ans.toLowerCase()) == 0) {
				System.out.println("Answer is correct, 50 points!!!");
			}else {
				System.out.println("Uh oh, wrong answer! But nice try.");
			}
			
		}
		sc.close();
	}
}
