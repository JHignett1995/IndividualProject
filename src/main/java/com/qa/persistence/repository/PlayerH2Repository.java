package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

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
	public String getAPlayer(String email) {
		return util.getJSONForObject(manager.find(Player.class, email));
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
		Player playerInDB = util.getObjectForJSON(getAPlayer(email), Player.class);

		if (manager.contains(manager.find(Player.class, email))) {
			manager.remove(manager.find(Player.class, email));
		}
		return "{\"message\": \"player sucessfully deleted\"}";
	}

	@Override
	public String getAPlayerPassword(String email) {
		Query query = manager.createQuery("SELECT Password FROM Player WHERE Email = email");
		Player aPlayer = (Player) query.getResultList();
		return aPlayer.getPassword();
	}

	@Override
	public boolean getAUserRights(String email) {
		Query query = manager.createQuery("SELECT isAdmin FROM Player WHERE Email = email");
		Player aPlayer = (Player) query.getResultList();
		return aPlayer.isAdmin();
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
