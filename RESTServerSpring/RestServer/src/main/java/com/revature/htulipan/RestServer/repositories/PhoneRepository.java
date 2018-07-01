package com.revature.htulipan.RestServer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.htulipan.RestServer.beans.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	
}
