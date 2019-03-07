package com.qa.persistence.repository;

public interface PlayerRepository {

	// C
	String createPlayer(String player);
	String getAPlayerName(String name);
	String getAPlayerWins(int wins);

	// R
	String getAllPlayers();

	String getAPlayerEmail(String email);

	// U
	String updatePlayer(String player, String email);

	// D
	String deletePlayer(String email);
	String getAPlayerChamp();
	String login(String email, String password);
}
