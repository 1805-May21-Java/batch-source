package com.Revature.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Revature.Beans.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Integer> {

}
