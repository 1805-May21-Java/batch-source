package com.revature.htulipan.Project1.pojos;

import java.sql.Date;

public class Employee {
	private final String username;
	private String firstname;
	private String lastname;
	private Date dob;
	private long phone;
	private String email;
	private final boolean manager;
	private final int employeeId;
	
	public Employee(String username, String firstname, String lastname, Date dob, long phone, String email,
			boolean manager, int employeeId) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.manager = manager;
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public boolean isManager() {
		return manager;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	@Override
	public String toString() {
		return "Employee [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", phone=" + phone + ", email=" + email + ", manager=" + manager + ", employeeid=" + employeeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + (manager ? 1231 : 1237);
		result = prime * result + (int) (phone ^ (phone >>> 32));
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
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (manager != other.manager)
			return false;
		if (phone != other.phone)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
