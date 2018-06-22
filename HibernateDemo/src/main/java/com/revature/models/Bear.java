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

}
