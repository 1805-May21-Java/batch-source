package com.revature.services;

import java.util.List;

import com.revature.beans.Pokemon;

public interface PokemonService {

	public Pokemon findPokemonById(int id);
	public List<Pokemon> findAllPokemon();
	public Pokemon createPokemon(Pokemon p);
	public Pokemon updatePokemon(Pokemon p);
	public Pokemon deletePokemon(Pokemon p);
	
}
