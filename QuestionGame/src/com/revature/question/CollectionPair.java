package com.revature.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CollectionPair {
	
	public static void main(String[] args) {
		
		
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> question = new ArrayList<String>();
		
//		//Adding the 10 name
//		name.add("Quinton Racquel");
//		name.add("Lorraine Marlee");
//		name.add("Chalice Tilly");
//		name.add("Daisy Borghild");
//		name.add("Paul Aiolos");
//		name.add("Suzie Caiden");
//		name.add("Johnathan Calanthia");
//		name.add("Letha Terpsichore");
//		name.add("Randy Balfour");
//		name.add("Alannis Aline");
//		
//		//adding the 10 questions
//		question.add("If you could play any instrument, what would you choose?");
//		question.add("Have you ever been done karaoke?");
//		question.add("What is the scarest animal you've seen in the wild?");
//		question.add("Do you have any allergies?");
//		question.add("Which do you like better, mountains or oceans?");
//		question.add("Which do you like better, long hair or short hair?");
//		question.add("Where are you originally from?");
//		question.add("Where is you favorite place to eat?");
//		question.add("Have you ever ran in a race?");
//		question.add("Do you like the beach?");
		
		//create the reader for name.txt
		BufferedReader br1 = null;
		String path1 = "src/com/revature/question/name.txt";
		
		try {
			br1 = new BufferedReader(new FileReader(path1));
			String line1 = br1.readLine();

			//check if this line is null
			while(line1 != null) {
				name.add(line1);
				line1 = br1.readLine();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//creating one for questions
		BufferedReader br2 = null;
		String path2 = "src/com/revature/question/question.txt";
		
		try {
			br2 = new BufferedReader(new FileReader(path2));
			String line2 = br2.readLine();
			
			//check if this line is null
			while(line2 != null) {
				question.add(line2);
				line2 = br2.readLine();

			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// set up the needed variabels
		int z = 10;
		int y = 10;
		Random rand = new Random();
		//array list that combines the 2 strings together
		ArrayList<PairProcess> pairProcess = new ArrayList<PairProcess>();
		
		for(int i = 0; i < name.size(); i++) {
			
			int j = rand.nextInt(z);
			int l = rand.nextInt(y);
			//find the 2 random number, then use the 2 number's placement out of the 2 arraylist to make a new
			//arraylist and add it in
			pairProcess.add(i, new PairProcess(name.get(j), question.get(l)));
			z--;
			y--;
			//remove the max number of rand, and remove the used names from the arraylist
			name.remove(j);
			question.remove(l);
		}
		
		Scanner scan = new Scanner(System.in);
		//for every input in the arraylist, print it out
		for (PairProcess p : pairProcess) {
			System.out.println(p);
			System.out.println("Please enter your answer: ");
			//scan.nextLine();
			//making sure the input will not be empty, otherwise redo the question
			if(scan.nextLine().isEmpty()) {
				System.out.println("Invalide Answer, please answer again");
				System.out.println(p);
				scan.nextLine();
			}
		}
	}

}
