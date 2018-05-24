package com.revature.quiz;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class QuizDriver {

	public static void main(String[] args) {
		QuizAdministrator qa = new QuizAdministrator();
		Scanner input = new Scanner(System.in);
		
		try {
			File associateFile = new File("./associates.txt");
			File questionFile = new File("./questions.txt");
			
			Scanner associateReader = new Scanner(associateFile);
			Scanner questionReader = new Scanner(questionFile);
			
			while(associateReader.hasNextLine()) {
				qa.addAssociate(associateReader.nextLine());
			}
			
			while(questionReader.hasNextLine()) {
				qa.addQuestion(questionReader.nextLine());
			}
			
			associateReader.close();
			questionReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Time to test your knowledge of Java!");
		System.out.println("At any point, you may input one of the following options:");
		System.out.println("[Enter] to continue");
		System.out.println("[q] then [Enter] to quit");
		int i = 1;
		
		while(true) {
			System.out.println();
			qa.randomQuestion(i);
			System.out.println();
			System.out.print("Option: ");
			String nextLine = input.nextLine();
			char option = 'x';
			if(nextLine.length() > 0)
				option = input.nextLine().charAt(0);
			if(option == 'q' || option == 'Q')
				break;
			i++;
		}
		System.out.println("Thank you for playing!");
	}

}
