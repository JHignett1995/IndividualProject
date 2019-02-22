package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.GameRepository;
import com.qa.persistence.repository.PlayerRepository;

public class GameServiceImpl implements GameService{

	@Inject
	private GameRepository Repo;

	@Override
	public String addGame(String gameP1, String gameP2) {
		return Repo.createGame(gameP1, gameP2);
	}

	@Override
	public String getAllGames() {
		return Repo.getAllGames();
	}

	@Override
	public String getAGame(Long refNum) {
		return Repo.getAGame(refNum);
	}

	@Override
	public String updateGame(String gameP1, String gameP2, Long refNum) {
		
		return Repo.updateGame(gameP1, gameP2, refNum);
	}

	@Override
	public String deleteGame(Long refNum) {
		return Repo.deleteGame(refNum);
	}

	public void setRepo(GameRepository Repo) {
		this.Repo = Repo;
	}

	
}
