package com.qa.service;


public interface PlayerService {
	// C
	String addPlayer(String player);

	// R
	String getAllPlayers();

	String getAPlayer(String email);

	String getAPlayerPassword(String email);
	
	boolean getAUserRights(String email);

	// U
	String updatePlayer( String player, String email);

	// D
	String deletePlayer( String email);
}
