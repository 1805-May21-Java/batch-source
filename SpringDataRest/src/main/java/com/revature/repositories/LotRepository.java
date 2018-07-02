package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.revature.models.Lot;

@RestResource(path="lots")
public interface LotRepository extends JpaRepository<Lot, Integer> {

}
