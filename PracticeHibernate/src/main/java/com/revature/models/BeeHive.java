package com.revature.models;

public class BeeHive {
	int id;
	int weight;
	
	@Override
	public String toString() {
		return "BeeHive [id=" + id + ", weight=" + weight + "]";
	}
	public BeeHive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
