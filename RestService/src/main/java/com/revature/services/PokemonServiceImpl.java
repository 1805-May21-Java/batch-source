package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Pokemon;
import com.revature.repositories.PokemonRepository;

@Service
@Transactional
public class PokemonServiceImpl implements PokemonService{
	
	@Autowired
	PokemonRepository pokeRepo;

	@Override
	public Pokemon findPokemonById(int id) {
		return pokeRepo.getOne(id);
	}

	@Override
	public List<Pokemon> findAllPokemon() {
		return pokeRepo.findAll();
	}

	@Override
	public Pokemon createPokemon(Pokemon p) {
		return pokeRepo.save(p);
	}

	@Override
	public Pokemon updatePokemon(Pokemon p) {
		return pokeRepo.save(p);
	}

	@Override
	public Pokemon deletePokemon(Pokemon p) {
		pokeRepo.delete(p);
		return p;
	}

}
