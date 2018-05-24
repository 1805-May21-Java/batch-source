package com.revature.questiongame;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestionGame {
	
	static ArrayList<String> questionList = new ArrayList<String>();
	static ArrayList<String> associateList = new ArrayList<String>();

	public static void main(String[] args) {
		
		String questionPath = "src/com/revature/questiongame/questions.txt";
		String associatePath = "src/com/revature/questiongame/associates.txt";
		
		try (
				BufferedReader questionReader = new BufferedReader(new FileReader(questionPath));
				BufferedReader associateReader = new BufferedReader(new FileReader(associatePath))
				){
			
			// Read in the questions
			String lineQ = questionReader.readLine();
			while (lineQ != null) {
				questionList.add(lineQ);
				lineQ = questionReader.readLine();
			}
			
			// Read in the associates
			String lineA = associateReader.readLine();
			while (lineA != null) {
				associateList.add(lineA);
				lineA = associateReader.readLine();
			}
			
			Scanner scanner = new Scanner(System.in);
			boolean gameLoop = true;
			int option;
			
			while(gameLoop) {
				System.out.println("Choose a menu option:");
				System.out.println("1: Display a new question for an associate.");
				System.out.println("2: Exit program.");
				
				
				try {
					option = scanner.nextInt();
					switch(option) {
					case 1: 
						askRandomQuestion();
						break;
					case 2: 
						gameLoop = false;
						break;
					default:
						System.out.println("'" + option + "' is not a valid option");
						break;
					}
					
				} catch(InputMismatchException e) {
					System.out.println("Please enter a number 1 or 2.");
					scanner.nextLine();
				} finally {
					System.out.println();
				}
				
				
			}
			scanner.close();
			
			System.out.println("Program Exited.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void askRandomQuestion() {
		String associate = associateList.get((int) (Math.random() * associateList.size()));
		String question = questionList.get((int) (Math.random() * questionList.size()));
		
		System.out.println();
		System.out.println(associate + ": " + question);
	}

}
