package com.revature.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Bear {
	
	int id;
	String name;
	Date birthday;
	List<Beehive> beehives = new ArrayList<Beehive>();
	Cave cave;
	
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Beehive> getBeehives() {
		return beehives;
	}
	public void setBeehives(List<Beehive> beehives) {
		this.beehives = beehives;
	}
	
	
	
	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", birthday=" + birthday + ", beehives=" + beehives + "]";
	}
	
	

}
