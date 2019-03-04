package com.qa.business;

public interface GameService {
	// C
	String addGame(String gameP1, String gameP2);

	// R
	String getAllGames();

	String getAGame(Long refNum);

	// U
	String updateGame(String gameP1, String gameP2, Long refNum);

	// D
	String deleteGame(Long refNum);
}
