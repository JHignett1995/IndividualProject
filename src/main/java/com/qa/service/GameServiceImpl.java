package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GameRepository;
import com.qa.persistence.repository.PlayerRepository;

public class GameServiceImpl implements GameService{

	@Inject
	private GameRepository gRepo;
	private PlayerRepository pRepo;

	@Override
	public String addGame(String game) {
		return gRepo.createGame(game);
	}

	@Override
	public String getAllGames() {
		return gRepo.getAllGames();
	}

	@Override
	public String getAGame(Long id) {
		return gRepo.getAGame(id);
	}

	@Override
	public String updateGame(String game, Long id) {
		
		return gRepo.updateGame(game, id);
	}

	@Override
	public String deleteGame(Long id) {
		return gRepo.deleteGame(id);
	}

}
