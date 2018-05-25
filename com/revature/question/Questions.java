package com.revature.question;

public class Questions {
	private String query;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(String query) {
		super();
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((query == null) ? 0 : query.hashCode());
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
		Questions newQ = (Questions) obj;
		if (query == null) {
			if (newQ.query != null)
				return false;
		} else if (!query.equals(newQ.query))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return query;
	}
	 
}
