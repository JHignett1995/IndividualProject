package com.qa.persistence.repository;

public interface GameRepository {
	
	//C
	String createGame(String game);
	//R
	String getAGame(Long id);
	
	String getAllGames();
	//U
	String updateGame(String game, Long id);
	//D
	String deleteGame(Long id);
}
