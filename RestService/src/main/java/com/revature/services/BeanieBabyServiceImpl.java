package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.BeanieBaby;
import com.revature.repositories.BeanieBabyRepository;

@Service
@Transactional
public class BeanieBabyServiceImpl implements BeanieBabyService{
	@Autowired
	BeanieBabyRepository bbRepo;

	@Override
	public BeanieBaby findBeanieBabiesById(int id) {
		return bbRepo.getOne(id);
	}

	@Override
	public List<BeanieBaby> findAllBeanieBabies() {
		return bbRepo.findAll();
	}

	@Override
	public BeanieBaby createBeanieBaby(BeanieBaby beanieBaby) {
		return bbRepo.save(beanieBaby);
	}

	@Override
	public BeanieBaby updateBeanieBaby(BeanieBaby beanieBaby) {
		return bbRepo.save(beanieBaby);
	}

	@Override
	public BeanieBaby deleteBeanieBaby(BeanieBaby beanieBaby) {
		bbRepo.delete(beanieBaby);
		return beanieBaby;
	}

}
