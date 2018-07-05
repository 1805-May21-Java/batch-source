package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Person;

@RestController
public class PersonController {
	
	protected Logger logger = Logger.getLogger(PersonController.class.getName());
	
	private List<Person> persons;
	
	public PersonController() {
		persons = new ArrayList<Person>();
		persons.add(new Person("Bob_Ross", 52, 5.9));
		persons.add(new Person("Bobby_Joe", 22, 3.6));
		persons.add(new Person("Ricky_Bobby", 40, 5.2));
	}
	
	@GetMapping
	public List<Person> getAll(){
		logger.info("PersonController.getAll");
		return persons;
	}
	
	@GetMapping(value="{personName}")
	public Person findByName(@PathVariable("personName") String personName) {
		for(Person p : persons) {
			if(p.getName().equals(personName)) {
				return p;
			}
		}
		return null;
	}
	
	

}
