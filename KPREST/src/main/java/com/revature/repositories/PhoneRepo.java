package com.revature.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.beans.*;

public interface PhoneRepo extends JpaRepository<Phone,Integer>{
	
}
