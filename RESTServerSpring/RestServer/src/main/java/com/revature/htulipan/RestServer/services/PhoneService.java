package com.revature.htulipan.RestServer.services;

import java.util.List;

import com.revature.htulipan.RestServer.beans.Phone;

public interface PhoneService {
	public Phone getPhoneById(int id);
	public List<Phone> getAllPhones();
	public Phone createPhone(Phone phone);
	public Phone updatePhone(Phone phone);
	public Phone deletePhone(Phone phone);
}
