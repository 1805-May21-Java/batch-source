package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.StoreOutOfStockException;
import com.revature.model.Firework;

@WebService(endpointInterface="com.revature.service.FireworksStore")
public class FireworksStoreImpl implements FireworksStore{

	@Override
	public List<Firework> getAllFireworks() {
		List<Firework> fireList = new ArrayList<Firework>();
		fireList.add(new Firework("Sparklers", "Assorted", 1));
		fireList.add(new Firework("Roman Candles", "Gold", 50));
		fireList.add(new Firework("Bottle Rocket", "Green", 9001));
		return fireList;
	}

	@Override
	public String addFirework(Firework firework) throws StoreOutOfStockException {
		if(firework.getName().equalsIgnoreCase("Molotov")) {
			throw new StoreOutOfStockException("We do not sell " + firework.getName());
		}else {
			return "Successfully added " + firework.getName() + " to cart.";
		}
	}

	@Override
	public String launchFirework(Firework firework) {
		if(firework.getExplosivePower() < 20) {
			return "Meh, weak blast.";
		}else {
			return "WOOHOO look at that blast!";
		}
	}

	@Override
	public int launchAllFireworks(List<Firework> fireworks) {
		int explosivesCombined = 0;
		for(Firework f : fireworks) {
			explosivesCombined += f.getExplosivePower();
		}
		return explosivesCombined;
		
	}
	
	
	
	

}
