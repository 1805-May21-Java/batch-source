package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.TreeTooOldException;
import com.revature.models.Tree;

@WebService
public interface Forest {

	public List<Tree> getALlTreess();
	
	public String plantTree(int id , int numberOfLeaves , String color , int ageInYears) throws TreeTooOldException;
	

}
