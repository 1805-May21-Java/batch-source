package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Snapple;

@WebService
public interface SnappleCollection {
	public List<Snapple> getAll();
	public Snapple addFact(Snapple snapple);
	
}
