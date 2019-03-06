package com.qa.persistence.repository;

public interface PlayerRepository {

	// C
	String createPlayer(String player);

	// R
	String getAllPlayers();

	String getAPlayerEmail(String email);

	String getAPlayerPassword(String email);
	
	boolean getAUserRights(String email);

	// U
	String updatePlayer(String player, String email);

	// D
	String deletePlayer(String email);
}
