package com.revature.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Bear {
	
	int id;
	String name;
	Date birthday;
	List<BeeHive> beehives = new ArrayList<BeeHive>();
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
	public List<BeeHive> getBeehives() {
		return beehives;
	}
	public void setBeehives(List<BeeHive> beehives) {
		this.beehives = beehives;
	}
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", birthday=" + birthday + ", beehives=" + beehives + "]";
	}

}
