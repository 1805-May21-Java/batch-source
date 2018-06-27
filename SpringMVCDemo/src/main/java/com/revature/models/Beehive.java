package com.revature.models;

import javax.persistence.*;

@Entity
@Table
public class Beehive {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="beehiveSequence")
	@SequenceGenerator(allocationSize=1, name="beehiveSequence", sequenceName="SQ_BEEHIVE_PK")
	@Column(name="BEEHIVE_ID")
	int id;
	
	@Column
	int weight;
	
	public Beehive() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Beehive(int weight) {
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
		return "Beehive [id=" + id + ", weight=" + weight + "]";
	}
	
	

}
