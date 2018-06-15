package com.revature.pojos;

public class ReimbursementRequest
{
	private int requestId;
	private Employee employee;
	private boolean isPending;
	private String description;
	private String filename;
	private double value;
	private Employee approver;
	
	public ReimbursementRequest()
	{
		super();
	}

	public ReimbursementRequest(int requestId, Employee employee, boolean isPending, String description, String filename,
			double value, Employee approver)
	{
		super();
		this.requestId = requestId;
		this.employee = employee;
		this.isPending = isPending;
		this.description = description;
		this.filename = filename;
		this.value = value;
		this.approver = approver;
	}
	
	public ReimbursementRequest(int requestId, Employee employee, boolean isPending, String description, double value,
			Employee approver)
	{
		super();
		this.requestId = requestId;
		this.employee = employee;
		this.isPending = isPending;
		this.description = description;
		this.value = value;
		this.approver = approver;
		this.filename = "";
	}

	public int getRequestId()
	{
		return requestId;
	}

	public void setRequestId(int requestId)
	{
		this.requestId = requestId;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployeeId(Employee employee)
	{
		this.employee = employee;
	}

	public boolean isPending()
	{
		return isPending;
	}

	public void setPending(boolean isPending)
	{
		this.isPending = isPending;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public Employee getApprover()
	{
		return approver;
	}

	public void setApproverId(Employee approver)
	{
		this.approver = approver;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approver == null) ? 0 : approver.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + (isPending ? 1231 : 1237);
		result = prime * result + requestId;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementRequest other = (ReimbursementRequest) obj;
		if (approver == null)
		{
			if (other.approver != null)
				return false;
		}
		else if (!approver.equals(other.approver))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (employee == null)
		{
			if (other.employee != null)
				return false;
		}
		else if (!employee.equals(other.employee))
			return false;
		if (filename == null)
		{
			if (other.filename != null)
				return false;
		}
		else if (!filename.equals(other.filename))
			return false;
		if (isPending != other.isPending)
			return false;
		if (requestId != other.requestId)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ReimbursementRequest [requestId=" + requestId + ", employee=" + employee + ", isPending=" + isPending
				+ ", description=" + description + ", filename=" + filename + ", value=" + value + ", approver="
				+ approver + "]";
	}
}
