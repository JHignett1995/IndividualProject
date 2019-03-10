package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.GameRepository;
import com.qa.persistence.repository.PlayerRepository;

public class GameServiceImpl implements GameService{

	@Inject
	private GameRepository Repo;

	@Override
	public String addGame(String player1, String player2) {
		System.out.println("serviceIMPL: " + player1 + "  " + player2);
		return Repo.createGame(player1, player2);
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
	public String getAGamebyPlayer(String email) {
		return Repo.getAGameByPlayer(email);
	}

	@Override
	public String updateGame(String winnerEmail, String loserEmail, Long refNum, boolean count7Ball) {
		
		return Repo.updateGame(winnerEmail, loserEmail, refNum, count7Ball);
	}

	@Override
	public String deleteGame(Long refNum) {
		return Repo.deleteGame(refNum);
	}

	public void setRepo(GameRepository Repo) {
		this.Repo = Repo;
	}

	
}
