package com.revature.beans;

public class Tree
{
	private int id;
	private int numberOfLeaves;
	private String color;
	private int ageInYears;
	public Tree()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Tree(int id, int numberOfLeaves, String color, int ageInYears)
	{
		super();
		this.id = id;
		this.numberOfLeaves = numberOfLeaves;
		this.color = color;
		this.ageInYears = ageInYears;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getNumberOfLeaves()
	{
		return numberOfLeaves;
	}
	public void setNumberOfLeaves(int numberOfLeaves)
	{
		this.numberOfLeaves = numberOfLeaves;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public int getAgeInYears()
	{
		return ageInYears;
	}
	public void setAgeInYears(int ageInYears)
	{
		this.ageInYears = ageInYears;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ageInYears;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + id;
		result = prime * result + numberOfLeaves;
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
		Tree other = (Tree) obj;
		if (ageInYears != other.ageInYears)
			return false;
		if (color == null)
		{
			if (other.color != null)
				return false;
		}
		else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		if (numberOfLeaves != other.numberOfLeaves)
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "Tree [id=" + id + ", numberOfLeaves=" + numberOfLeaves + ", color=" + color + ", ageInYears="
				+ ageInYears + "]";
	}
}
