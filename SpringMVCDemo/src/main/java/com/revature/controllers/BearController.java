package com.revature.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.BearDaoImpl;
import com.revature.exceptions.BearNotFoundException;
import com.revature.models.Bear;

@Controller
public class BearController {

	@Autowired
	BearDaoImpl bdi;
	
	@GetMapping("/bears") //@RequestMapping(value="/bears", method=RequestMethod.GET)
	@ResponseBody
	public List<Bear> getBears(){
		return bdi.getBears();
	}
	
	@GetMapping("/bears/{id}")
	@ResponseBody
	public Bear getBearByPathId(@PathVariable("id") int id) {
		Bear b = bdi.getBearById(id);
		if(b == null) {
			throw new BearNotFoundException();
		}
		return b;
	}
	
	@RequestMapping(value="bears/search", method=RequestMethod.GET)
	public String getSearchPage() {
		//return "forward:/static/SearchBear.html";
		return "SearchBear";
	}
	
	/*
	//@RequestMapping(value="bears/search", method=RequestMethod.POST)
	@PostMapping("/bears/search")
	public String getBear(@RequestParam("id") int bearId) {
		return "redirect:/bears/"+bearId;
	}
	*/
	
	//can still use HttpServletRequest
	@PostMapping("/bears/search")
	public String getBear(HttpServletRequest req) {
		String bearId = req.getParameter("id");
		return "redirect:/bears/"+bearId;
	}
	
	@RequestMapping(value="/bears/create", method=RequestMethod.GET)
	public String getCreatePage() {
		return "NewBear";
	}
	
	@RequestMapping(value="/bears/create", method=RequestMethod.POST)
	public String addBear(@RequestParam("name") String name, @RequestParam("birthday") Date birthday) {
		bdi.createBear(new Bear(name, birthday));
		return "redirect:/static/NewBear.html";
	}
	
}


