package com.revature.htulipan.questiongame;

import java.io.File;

public class QuestionGameDriver {

	public static void main(String[] args) {
		File namesInput = new File("./src/com/revature/htulipan/questiongame/Associate.txt");
		File questionsInput = new File("./src/com/revature/htulipan/questiongame/Question.txt");
		AssociateSet as = new AssociateSet(namesInput);
		QuestionSet qs = new QuestionSet(questionsInput);
		
		while (qs.moreQuestions()) {
			System.out.println(as.getRandom());
			System.out.println(qs.getRandom());
		}
	}

}
