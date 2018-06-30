package com.revature.services;

import java.util.List;

import com.revature.beans.BeanieBaby;

public interface BeanieBabyService {
	public BeanieBaby findBeanieBabiesById(int id);
	public List<BeanieBaby> findAllBeanieBabies();
	public BeanieBaby createBeanieBaby(BeanieBaby beanieBaby);
	public BeanieBaby updateBeanieBaby(BeanieBaby beanieBaby);
	public BeanieBaby deleteBeanieBaby(BeanieBaby beanieBaby);
}
