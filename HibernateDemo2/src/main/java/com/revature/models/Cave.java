package com.revature.models;

import javax.persistence.*;

@Entity
@Table
public class Cave {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caveSequence")
	@SequenceGenerator(allocationSize=1, name="caveSequence", sequenceName="SQ_CAVE_PK")
	@Column(name="CAVE_ID")
	int id;
	
	@Column(name="CAVE_NAME")
	String name;
	
	public Cave() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cave(String name) {
		super();
		this.name = name;
	}



	public Cave(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + "]";
	}
	
	
	

}