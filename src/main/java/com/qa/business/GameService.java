package com.qa.business;

public interface GameService {
	// C
	String addGame(String player1, String player2);

	// R
	String getAllGames();

	String getAGame(Long refNum);

	// U
	String updateGame(String winnerEmail, String loserEmail, Long refNum, boolean count7Ball);

	// D
	String deleteGame(Long refNum);

	String getAGamebyPlayer(String email);
}
