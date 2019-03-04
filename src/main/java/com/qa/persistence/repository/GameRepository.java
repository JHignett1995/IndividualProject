package com.qa.persistence.repository;

public interface GameRepository {
	
	//C
	String createGame(String gameP1, String gameP2);
	//R
	String getAGame(Long id);
	
	String getAllGames();
	//U
	String updateGame(String gameP1, String gameP2, Long id);
	//D
	String deleteGame(Long id);
}
