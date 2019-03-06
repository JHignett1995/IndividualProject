package com.qa.business;


public interface PlayerService {
	// C
	String addPlayer(String player);

	// R
	String getAllPlayers();

	String getAPlayerEmail(String email);

	String getAPlayerPassword(String email);
	
	boolean getAUserRights(String email);

	// U
	String updatePlayer( String player, String email);

	// D
	String deletePlayer( String email);

	String getAPlayerWins(int wins);

	String getAPlayerName(String name);

	String getAPlayerChamp();
}
