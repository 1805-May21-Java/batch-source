package com.revature.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Hero {
	@Id
	@Column(name = "HERO_ID")
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String localizedName;
	
	public Hero() {
		
	}
	
	public Hero(String name, long id, String localizedName) {
		this.name = name;
		this.id = id;
		this.localizedName = localizedName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalizedName() {
		return localizedName;
	}

	public void setLocalizedName(String localizedName) {
		this.localizedName = localizedName;
	}
	
	
	
}
