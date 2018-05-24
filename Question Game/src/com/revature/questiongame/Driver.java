package com.revature.questiongame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver
{

	public static void main(String[] args)
	{
		String input;
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		String path1 = "src/com/revature/questiongame/AssociateNames";
		String path2 = "src/com/revature/questiongame/Questions";
		
		
		LinkedList<AssociateNames> associateList = new LinkedList<AssociateNames>();
		
//		associateList.add(new AssociateNames("Rod"));
//		associateList.add(new AssociateNames("Devon"));
//		associateList.add(new AssociateNames("will"));
//		associateList.add(new AssociateNames("Ryan"));
//		associateList.add(new AssociateNames("Sara"));
//		associateList.add(new AssociateNames("Marceline"));
//		
		LinkedList<Questions> questionList = new LinkedList<Questions>();
		
//		questionList.add(new Questions("How old are you?"));
//		questionList.add(new Questions("Where did you go to school?"));
//		questionList.add(new Questions("What degree do you have?"));
//		questionList.add(new Questions("What is your experience?"));
//		questionList.add(new Questions("What is your name?"));
//		questionList.add(new Questions("Are you willing to relocate?"));

		try
		{
			br = new BufferedReader(new FileReader(path1));
			String line;
			
			//read the file until there are no more lines
			while((line = br.readLine()) != null)
			{
				associateList.add(new AssociateNames(line));
			}
			br.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			br = new BufferedReader(new FileReader(path2));
			String line;
			
			//read the file until there are no more lines
			while((line = br.readLine()) != null)
			{
				questionList.add(new Questions(line));
			}
			br.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Iterator<AssociateNames> iNames = associateList.iterator();
		Iterator<Questions> iQuestions = questionList.iterator();
		
		Collections.shuffle(associateList);
		Collections.shuffle(questionList);
		
		System.out.println("To ask a question press Enter");
		
		while(iNames.hasNext() && iQuestions.hasNext())
		{
			input = sc.nextLine();
			if(input.equals(""))
			{
				AssociateNames a = iNames.next();
				Questions q = iQuestions.next();
				System.out.println(a.getName()+": " + "" +q.getQuestion());
			}
			else
			{
				System.out.println("Please press enter to ask the next quetions");
			}
		}
	}

}
