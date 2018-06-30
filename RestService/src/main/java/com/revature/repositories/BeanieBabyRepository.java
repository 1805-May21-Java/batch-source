package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.BeanieBaby;

@Repository
public interface BeanieBabyRepository extends JpaRepository<BeanieBaby, Integer>{

}
