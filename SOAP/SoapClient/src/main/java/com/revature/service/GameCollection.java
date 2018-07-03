package com.revature.service;
import javax.jws.WebService;

import com.revature.model.Game;

import java.util.List;

@WebService
public interface GameCollection {
	public List<Game> getGames();
	public String addGame(Game game);
}
