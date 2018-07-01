package com.revature.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Bear {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bearSequence")
	@SequenceGenerator(allocationSize=1, name="bearSequence", sequenceName="SQ_BEAR_PK")
	@Column(name="BEAR_ID")
	int id;
	
	@Column(name="BEAR_NAME", columnDefinition="VARCHAR2(25)" ) //length=25)
	String name;
	
	@Column
	Date birthday;
	
	//@Transient
	@ManyToMany
	@JoinTable(
			name="BEAR_BeeHive",
			joinColumns = { @JoinColumn(name="BEAR_ID") }, //columns from this table 
			inverseJoinColumns = { @JoinColumn(name="BeeHive_ID")} ) //columns from BeeHive table
	List<BeeHive> BeeHives = new ArrayList<BeeHive>();
	
	//@Transient
	@ManyToOne
	@JoinColumn(name="CAVE_ID")
	Cave cave;
	
	
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Bear(String name, Date birthday, Cave cave) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.cave = cave;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<BeeHive> getBeeHives() {
		return BeeHives;
	}

	public void setBeeHives(List<BeeHive> BeeHives) {
		this.BeeHives = BeeHives;
	}
	
	public void addBeeHive(BeeHive b) {
		this.BeeHives.add(b);
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", birthday=" + birthday + ", BeeHives=" + BeeHives + ", cave="
				+ cave + "]";
	}
	

}