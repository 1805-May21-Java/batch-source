package com.revature.pojos;

import java.sql.Date;

public class Employee {
	
	private int empId;
	private String empName;
	private String userName;
	private String userPass;
	private int reportTo;
	private Date birthDate;
	private String url;
	
	public Employee(
			int empId, String empName, String userName, String userPass, int reportTo, Date birthDate, String url
	)
	{
		super();
		this.empId = empId;
		this.empName = empName;
		this.userName = userName;
		this.userPass = userPass;
		this.reportTo = reportTo;
		this.birthDate = birthDate;
		this.url = url;
	}
	
	public Employee(String empName, String userName, String userPass, int reportTo, Date birthDate, String url
	)
	{
		super();
		this.empName = empName;
		this.userName = userName;
		this.userPass = userPass;
		this.reportTo = reportTo;
		this.birthDate = birthDate;
		this.url = url;
	}

	
	public Employee()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmpId()
	{
		return empId;
	}

	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	public String getEmpName()
	{
		return empName;
	}

	public void setEmpName(String empName)
	{
		this.empName = empName;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPass()
	{
		return userPass;
	}

	public void setUserPass(String userPass)
	{
		this.userPass = userPass;
	}

	public int getReportTo()
	{
		return reportTo;
	}

	public void setReportTo(int reportTo)
	{
		this.reportTo = reportTo;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@Override
	public String toString()
	{
		return "Employee [empId=" + empId + ", empName=" + empName + ", userName=" + userName + ", userPass=" + userPass
				+ ", reportTo=" + reportTo + ", birthDate=" + birthDate + ", url=" + url + "]";
	}

	

}
