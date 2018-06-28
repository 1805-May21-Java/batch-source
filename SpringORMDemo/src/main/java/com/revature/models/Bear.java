package com.revature.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries( { @NamedQuery(name="findBearByCave", query = "from Bear where cave =:caveVar")})

@Entity
@Table
public class Bear {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bearSequence")
	@SequenceGenerator(allocationSize=1, name="bearSequence", sequenceName="SQ_BEAR_PK")
	@Column(name="BEAR_ID")
	int id;
	
	@Column(name="BEAR_NAME", columnDefinition="VARCHAR2(25)" ) //length=25)
//	@NotNull
//	@Size(min=2, max=30)
	String name;
	
	@Column
//	@Past
	Date birthday;
	
	//@Transient
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name="BEAR_BEEHIVE",
			joinColumns = { @JoinColumn(name="BEAR_ID") }, //columns from this table 
			inverseJoinColumns = { @JoinColumn(name="BEEHIVE_ID")} ) //columns from beehive table
	List<Beehive> beehives = new ArrayList<Beehive>();
	
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



	public Bear(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
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
	
	public void addBeehive(Beehive b) {
		this.beehives.add(b);
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", birthday=" + birthday + ", beehives=" + beehives + ", cave="
				+ cave + "]";
	}
	

}
