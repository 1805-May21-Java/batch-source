package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.model.Snapple;

@WebService(endpointInterface="com.revature.service.SnappleCollection")
public class SnappleCollectionImpl implements SnappleCollection{

	@Override
	public List<Snapple> getAll() {
		List<Snapple> factList = new ArrayList<Snapple>();
		factList.add(new Snapple(13, "Cats have over 100 vocal chords"));
		factList.add(new Snapple(19, "Children tend to grow faster in the spring"));
		factList.add(new Snapple(30, "Fish have eyelids"));
		
		
		return factList;
	}

	@Override
	public Snapple addFact(Snapple snapple) {
		
		return snapple;
	}

}
