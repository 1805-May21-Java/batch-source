package questiongame;

//class for questions
public class Questions {

	String question;

	public Questions() {
		super();
	}



	public Questions(String question) {
		super();
		this.question = question;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return question;
	}
	
	
	
}
