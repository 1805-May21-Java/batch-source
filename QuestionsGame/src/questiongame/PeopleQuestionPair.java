package questiongame;

public class PeopleQuestionPair {

	//creates an object that stores people and questions as a pair
	People person;
	Questions questions;
	public PeopleQuestionPair() {
		super();
	}
	public PeopleQuestionPair(People person, Questions questions) {
		super();
		this.person = person;
		this.questions = questions;
	}
	public People getPerson() {
		return person;
	}
	public void setPerson(People person) {
		this.person = person;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return person+", "+ questions;
	}
}
