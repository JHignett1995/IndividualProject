package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.PlayerRepository;

public class PlayerServiceImpl implements PlayerService {

	@Inject
	private PlayerRepository repo;

	@Override
	public String addPlayer( String player) {
		if(true) {//TODO
			return repo.createPlayer(player);
		}
		return "You don't have Admin rights";
	}

	@Override
	public String getAllPlayers() {
		return repo.getAllPlayers();
	}

	@Override
	public String getAPlayer(String email) {
		return repo.getAPlayer(email);
	}

	@Override
	public String updatePlayer( String player, String email) {
		if (true) {//TODO
			return repo.updatePlayer(player, email);
		}
		return "You are not signed into that account";
	}

	@Override
	public String deletePlayer( String email) {
		if (true) {//TODO
			return repo.deletePlayer(email);
		}
		return "You don't have Admin rights";
	}

	public void setRepo(PlayerRepository repo) {
		this.repo = repo;
	}

	@Override
	public String getAPlayerPassword(String email) {
		return repo.getAPlayerPassword(email);
	}

	@Override
	public boolean getAUserRights(String email) {
		
		return repo.getAUserRights(email);
	}

	
}
