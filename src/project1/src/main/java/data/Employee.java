package data;

public class Employee {
	long employeeId, reportsTo;
	String employeeName, password, username;
	
	public Employee(long employeeId, long reportsTo, String employeeName, String password, String username){
		this.employeeId = employeeId;
		this.reportsTo = reportsTo;
		this.employeeName = employeeName;
		this.password = password;
		this.username = username;
	}
	public Employee(long employeeId, String employeeName, String password, String username){
		this.employeeId = employeeId;
//		this.reportsTo = -1;
		this.employeeName = employeeName;
		this.password = password;
		this.username = username;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(long reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
