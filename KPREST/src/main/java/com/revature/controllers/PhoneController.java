package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.*;
import com.revature.services.*;

@RestController
@RequestMapping("/phones")
public class PhoneController {
	
	@Autowired
	PhoneServ phoneserv;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Phone> getAllPhones(){
		return phoneserv.getAllPhones();
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Phone getPhoneById(@PathVariable("id") Integer id) {
		return phoneserv.findPhoneByID(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Phone makePhone(@RequestBody Phone phone) {
		return phoneserv.makePhone(phone);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Phone updatePhone (@RequestBody Phone phone) {
		return phoneserv.updatePhone(phone);
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Phone deletePhone(@RequestBody Phone phone) {
		phoneserv.deletePhone(phone);
		return phone;
	}
	
	@RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.TRACE })
	public Phone metaPhoneData() {
		return null;
	}
}
