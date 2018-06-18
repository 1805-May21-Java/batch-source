package com.revature.questiongame;

public class AssociateNames implements Comparable<AssociateNames>
{
	private String name;

	public AssociateNames(String name)
	{
		super();
		this.name = name;
	}


	public AssociateNames()
	{
		super();
	}

	@Override
	public String toString()
	{
		return "AssociateNames [name=" + name + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AssociateNames other = (AssociateNames) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int compareTo(AssociateNames o)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}
