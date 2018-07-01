package com.revature.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.beans.*;
import com.revature.repositories.*;

@Service
@Transactional
public class PhoneServImpl implements PhoneServ{
	
	@Autowired
	PhoneRepo phoneRepo;
	
	@Override
	public Phone findPhoneByID(int id) {
		return phoneRepo.getOne(id);
	}
	
	@Override
	public List<Phone> getAllPhones(){
		return phoneRepo.findAll();
	}
	
	@Override
	public Phone makePhone(Phone phone) {
		return phoneRepo.save(phone);
	}
	
	@Override
	public Phone updatePhone(Phone phone) {
		return phoneRepo.save(phone);
	}
	
	@Override
	public Phone deletePhone(Phone phone) {
		phoneRepo.delete(phone);
		return phone;
	}
}
