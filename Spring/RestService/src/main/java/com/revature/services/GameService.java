package com.revature.services;

import java.util.List;

import com.revature.beans.Game;

public interface GameService {
	public Game findGameById(int id);
	public List<Game> findAllGames();
	public Game createGame(Game game);
	public Game updateGame(Game game);
	public Game deleteGame(Game game);
}
