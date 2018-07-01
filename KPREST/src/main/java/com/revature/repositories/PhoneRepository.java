package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.beans.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer>{
	
}
