package com.revature.services;

import java.util.*;
import com.revature.beans.*;

public interface PhoneServ {
	public Phone findPhoneByID(int id);
	public List<Phone> getAllPhones();
	public Phone makePhone(Phone phone);
	public Phone updatePhone(Phone phone);
	public Phone deletePhone(Phone phone);
}
