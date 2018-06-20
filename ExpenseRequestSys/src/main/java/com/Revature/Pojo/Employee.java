package com.Revature.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	private String username;
	private String pwd;
	private String firstName;
	private String lastName;
	private String email;
	private String reportsTo;
	private boolean isActive;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String pwd, String firstName, String lastName, String email, String reportsTo,
			boolean isActive) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.reportsTo = reportsTo;
		this.isActive = isActive;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	@JsonProperty(value="isActive")
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((reportsTo == null) ? 0 : reportsTo.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isActive != other.isActive)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (reportsTo == null) {
			if (other.reportsTo != null)
				return false;
		} else if (!reportsTo.equals(other.reportsTo))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", pwd=" + pwd + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", reportsTo=" + reportsTo + ", isActive=" + isActive + "]";
	}

}
