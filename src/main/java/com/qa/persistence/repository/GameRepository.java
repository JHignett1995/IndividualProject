package com.qa.persistence.repository;

public interface GameRepository {
	
	//C
	String createGame(String player1, String player2);
	//R
	String getAGame(Long id);
	
	String getAllGames();
	//U
	String updateGame(String winnerEmail, String loserEmail, Long id, boolean count7Ball);
	//D
	String deleteGame(Long id);
	String getAGameByPlayer(String email);
}
