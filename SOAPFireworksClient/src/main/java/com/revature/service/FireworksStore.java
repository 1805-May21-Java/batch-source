package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Firework;

@WebService
public interface FireworksStore {
	
	public List<Firework> getAllFireworks();
	public String addFirework(Firework firework);
	public String launchFirework(Firework firework);
	public int launchAllFireworks(List<Firework> fireworks);

}
