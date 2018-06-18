package com.revature.pojos;

public class employee {
	private int e_Id;
	private String empName;
	private String empType;
	private String uName;
	private String uPass;
	private String ePosition;
	
	public int getE_Id() {
		return e_Id;
	}
	public void setE_Id(int e_Id) {
		this.e_Id = e_Id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public String getePosition() {
		return ePosition;
	}
	public void setePosition(String ePosition) {
		this.ePosition = ePosition;
	}
	public employee(int e_Id, String empName, String empType, String uName, String uPass, String ePosition) {
		super();
		this.e_Id = e_Id;
		this.empName = empName;
		this.empType = empType;
		this.uName = uName;
		this.uPass = uPass;
		this.ePosition = ePosition;
	}
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "employee [e_Id=" + e_Id + ", empName=" + empName + ", empType=" + empType + ", uName=" + uName
				+ ", uPass=" + uPass + ", ePosition=" + ePosition + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ePosition == null) ? 0 : ePosition.hashCode());
		result = prime * result + e_Id;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empType == null) ? 0 : empType.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + ((uPass == null) ? 0 : uPass.hashCode());
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
		employee other = (employee) obj;
		if (ePosition == null) {
			if (other.ePosition != null)
				return false;
		} else if (!ePosition.equals(other.ePosition))
			return false;
		if (e_Id != other.e_Id)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empType == null) {
			if (other.empType != null)
				return false;
		} else if (!empType.equals(other.empType))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (uPass == null) {
			if (other.uPass != null)
				return false;
		} else if (!uPass.equals(other.uPass))
			return false;
		return true;
	}
	
	
	
}
