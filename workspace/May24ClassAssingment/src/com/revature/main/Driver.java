package com.revature.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class Driver 
{

	 public static void pressEnterToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	public static void main(String[] args) 
	{

		BufferedReader myQuestions = null;
		BufferedReader myAssociates = null;
		String questions = "src/com/revature/files/questions.txt";
		String associates = "src/com/revature/files/associates.txt";
		
		
		try {
				myQuestions = new BufferedReader(new FileReader(questions));
				myAssociates = new BufferedReader(new FileReader(associates));
				HashMap<Integer, String> associatseMap = new HashMap<>();
				HashMap<Integer, String> questionsMap = new HashMap<>();
		
				String questionsLine = myQuestions.readLine();
				String associatesLine = myAssociates.readLine();
				// read the file until there are no more lines to read

				int i=0;
				int j=0;
				
				while(questionsLine != null || associatesLine !=null) 
				{
					if(associatesLine!=null)
					{
						associatseMap.put(++i, associatesLine);
						associatesLine = myAssociates.readLine();
					}
		
					if(questionsLine!=null)
					{
						questionsMap.put(++j, questionsLine);
						questionsLine = myQuestions.readLine();
					}
				}
				
				while(true)
				{
					int random = (int )(Math.random() * (i) + 1);
					int random2 = (int )(Math.random() * (j) + 1);
					System.out.println(associatseMap.get(random)+" : "+ questionsMap.get(random2) );
					pressEnterToContinue();
				}
	
			} 
		catch (IOException e) 
			{

					e.printStackTrace();
			}
	
	}

}
