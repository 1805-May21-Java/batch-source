package com.revature.htulipan.RestServer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.htulipan.RestServer.beans.Phone;
import com.revature.htulipan.RestServer.repositories.PhoneRepository;

@Service
@Transactional
public class PhoneServiceImp implements PhoneService {
	
	@Autowired
	PhoneRepository repo;

	@Override
	public Phone getPhoneById(int id) {
		return repo.getOne(id);
	}

	@Override
	public List<Phone> getAllPhones() {
		return repo.findAll();
	}

	@Override
	public Phone createPhone(Phone phone) {
		return repo.save(phone);
	}

	@Override
	public Phone updatePhone(Phone phone) {
		return repo.save(phone);
	}

	@Override
	public Phone deletePhone(Phone phone) {
		repo.delete(phone);
		return phone;
	}
	
}
