package com.qa.business;

import java.util.ArrayList;

import javax.inject.Inject;

import com.qa.persistence.domain.Player;
import com.qa.persistence.repository.PlayerRepository;
import com.qa.util.JSONUtil;

public class PlayerServiceImpl implements PlayerService {

	// @Inject
	private JSONUtil util = new JSONUtil();

	@Inject
	private PlayerRepository repo;
	// (email, name, title, password)

	// (id, player1Id, player2Id, winnerID, loserID) (DEFAULT, 1, 2, 1, 2)

	@Override
	public String addPlayer(String player) {

		Player newPlayer = util.getObjectForJSON(player, Player.class);

		if (true) {
			for (int i = 0; i < newPlayer.getName().length(); i++) {
				if (newPlayer.getName().toLowerCase().matches("\\W.*")) {
					return "{\"message\": \"You have entered an invalid character\"}";
				}
				if (newPlayer.getName().matches("\\d.*")) {
					return "{\"message\": \"You have entered an invalid character\"}";
				}
			}
			String[] bannedWords = { "shit", "fuck", "cunt", "asshole", "bitch", "bastard", "dick", "pussy",
					"ballbag" };
			for (int i = 0; i < bannedWords.length; i++) {
				if (newPlayer.getName().toLowerCase().contains(bannedWords[i])) {
					return "{\"message\": \"You have entered an name containing profanity\"}";
				}
			}

			if (newPlayer.getPassword().length() < 6) {
				return "{\"message\": \"You have entered an incorrect password, password must be 6 chars minimal\"}";
			}
			for (int i = 0; i < newPlayer.getPassword().length(); i++) {
				if (newPlayer.getPassword().matches("[0-9].")) {
					return "{\"message\": \"You have entered an incorrect password, password must contain a number\"}";
				}

				if (newPlayer.getPassword().matches("[A-Z].")) {
					return "{\"message\": \"You have entered an incorrect password, password must contain a capitial\"}";
				}
			}
			return "{\"message\": \"Player has been added\"}"; // repo.createPlayer(player);
		}
		return "{\"message\": \"You don't have Admin rights\"}";
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
	public String updatePlayer(String player, String email) {
		if (true) {// TODO
			return repo.updatePlayer(player, email);
		}
		return "You are not signed into that account";
	}

	@Override
	public String deletePlayer(String email) {
		if (true) {// TODO
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
