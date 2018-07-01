package com.revature.models;

import javax.persistence.*;

@Entity
@Table
public class BeeHive {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BeeHiveSequence")
	@SequenceGenerator(allocationSize=1, name="BeeHiveSequence", sequenceName="SQ_BeeHive_PK")
	@Column(name="BeeHive_ID")
	int id;
	
	@Column
	int weight;
	
	public BeeHive() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BeeHive(int weight) {
		super();
		this.weight = weight;
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
	@Override
	public String toString() {
		return "BeeHive [id=" + id + ", weight=" + weight + "]";
	}
	
	

}