package com.revature.services;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.beans.Game;
import com.revature.repositories.GameRepository;

@Service
@Transactional
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameRepository gameRepo;
	
	public Game findGameById(int id) {
		return gameRepo.getOne(id);
	}

	public List<Game> findAllGames() {
		return gameRepo.findAll();
	}

	public Game createGame(Game game) {
		return gameRepo.save(game);
	}

	public Game updateGame(Game game) {
		return gameRepo.save(game);
	}

	public Game deleteGameById(int id) {
		Game game = gameRepo.getOne(id);
		gameRepo.deleteById(id);
		return game;
	}
}
