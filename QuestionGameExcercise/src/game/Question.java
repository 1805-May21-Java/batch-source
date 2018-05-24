package game;

import java.util.Comparator;

public class Question implements Comparator<Question>{
	
	String problem = "";
	String answer = "";
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String problem, String answer) {
		super();
		this.problem = problem;
		this.answer = answer;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public int compare(Question o1, Question o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
