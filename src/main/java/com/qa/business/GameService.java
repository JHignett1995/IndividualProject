package com.qa.business;

public interface GameService {
	// C
	String addGame(String game);

	// R
	String getAllGames();

	String getAGame(Long id);

	// U
	String updateGame(String game, Long id);

	// D
	String deleteGame(Long id);
}
