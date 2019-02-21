package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.GameRepository;
import com.qa.persistence.repository.PlayerRepository;

public class GameServiceImpl implements GameService{

	@Inject
	private GameRepository gRepo;

	@Override
	public String addGame(String gameP1, String gameP2) {
		return gRepo.createGame(gameP1, gameP2);
	}

	@Override
	public String getAllGames() {
		return gRepo.getAllGames();
	}

	@Override
	public String getAGame(Long refNum) {
		return gRepo.getAGame(refNum);
	}

	@Override
	public String updateGame(String gameP1, String gameP2, Long refNum) {
		
		return gRepo.updateGame(gameP1, gameP2, refNum);
	}

	@Override
	public String deleteGame(Long refNum) {
		return gRepo.deleteGame(refNum);
	}

}
