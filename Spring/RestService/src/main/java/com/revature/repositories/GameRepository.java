package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.beans.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>  {

}
