package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Player;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default

public class PlayerH2Repository implements PlayerRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createPlayer(String player) {
		Player aPlayer = util.getObjectForJSON(player, Player.class);
		manager.persist(aPlayer);
		return "{\"message\": \"Player has been added\"}";
	}

	@Override
	public String getAllPlayers() {
		Query query = manager.createQuery("SELECT a FROM Player a");
		Collection<Player> players = (Collection<Player>) query.getResultList();

		return util.getJSONForObject(players);
	}

	@Override
	public String getAPlayerEmail(String email) {
		Query query = manager.createQuery("SELECT a FROM Player a WHERE email='" + email + "'");
		Collection<Player> players = (Collection<Player>) query.getResultList();

		return util.getJSONForObject(players);
	}

	@Override
	public String getAPlayerWins(int wins) {
		Query query = manager.createQuery("SELECT a FROM Player a WHERE winCount=" + wins);
		Collection<Player> players = (Collection<Player>) query.getResultList();

		return util.getJSONForObject(players);
	}

	@Override
	public String getAPlayerChamp() {
		Query query = manager.createQuery("SELECT a FROM Player a WHERE title ='" + "Champ'");
		Collection<Player> players = (Collection<Player>) query.getResultList();

		return util.getJSONForObject(players);
	}

	@Override
	@Transactional(REQUIRED)
	public String updatePlayer(String player, String email) {
		Player aPlayer = manager.find(Player.class, email);
		deletePlayer(aPlayer.getEmail());
		createPlayer(player);
		return "{\"message\": \"player sucessfully Updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deletePlayer(String email) {
		System.out.println(email);
		Query query = manager.createQuery("SELECT a FROM Player a WHERE email='" + email + "'");		
		
		if (manager.contains(query.getFirstResult())) {
			manager.remove(query.getFirstResult());
			return "{\"message\": \"player sucessfully deleted\"}";
		}
		return "{\"message\": \"player not deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getAPlayerName(String name) {
		Query query = manager.createQuery("SELECT a FROM Player a WHERE name LIKE '%" + name + "%'");
		Collection<Player> players = (Collection<Player>) query.getResultList();
		return util.getJSONForObject(players);
	}

	@Override
	public String login(String email, String password) {
		String a = getAPlayerEmail(email);
		a = a.replaceFirst("\\[\\{", "{").replaceAll("\\}\\]", "}").trim();
		System.out.println(a);
		Player player = util.getObjectForJSON(a, Player.class);
		try {
			if (player.getEmail().equals(email)) {
				if (player.getPassword().equals(password)) {
					System.out.println("{\"message\": \"Login Successful\"}");
					return "{\"message\": \"Login Successful\"}";
				} else {
					
					return "{\"message\": \"Password incorrect\"}";
				}
			} else {
				return "{\"message\": \"Email incorrect\"}";
			}
		} catch (NullPointerException e) {
			return "{\"message\": \"Account Doesn't Exist\"}";
		}
	}
}
