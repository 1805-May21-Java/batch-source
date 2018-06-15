package com.revature.pojos;

public class ReimbursementRequest
{
	private int requestId;
	private int employeeId;
	private boolean isPending;
	private String description;
	private String filename;
	private double value;
	private int approverId;
	
	public ReimbursementRequest()
	{
		super();
	}

	public ReimbursementRequest(int requestId, int employeeId, boolean isPending, String description, String filename,
			double value, int approverId)
	{
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.isPending = isPending;
		this.description = description;
		this.filename = filename;
		this.value = value;
		this.approverId = approverId;
	}
	
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getRequestId()
	{
		return requestId;
	}
	public void setRequestId(int requestId)
	{
		this.requestId = requestId;
	}
	public int getEmployeeId()
	{
		return employeeId;
	}
	public void setEmployeeId(int employeeId)
	{
		this.employeeId = employeeId;
	}
	public boolean isPending()
	{
		return isPending;
	}
	public void setPending(boolean isPending)
	{
		this.isPending = isPending;
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
	public int getApproverId()
	{
		return approverId;
	}
	public void setApproverId(int approverId)
	{
		this.approverId = approverId;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + approverId;
		result = prime * result + employeeId;
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
		if (approverId != other.approverId)
			return false;
		if (employeeId != other.employeeId)
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
		return "ReimbursementRequest [requestId=" + requestId + ", employeeId=" + employeeId + ", isPending="
				+ isPending + ", filename=" + filename + ", value=" + value + ", approverId=" + approverId + "]";
	}	
}
