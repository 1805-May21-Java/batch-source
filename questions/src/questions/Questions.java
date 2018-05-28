package questions;

public class Questions {
	String Question;

	public Questions(String question) {
		super();
		Question = question;
	}

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Question == null) ? 0 : Question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questions other = (Questions) obj;
		if (Question == null) {
			if (other.Question != null)
				return false;
		} else if (!Question.equals(other.Question))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questions [Question=" + Question + "]";
	}
	
	
}
