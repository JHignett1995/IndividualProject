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
		System.out.println(aPlayer.isAdmin());
		Player b = new Player(aPlayer.getEmail(),aPlayer.getName(), aPlayer.getPassword());
		b.setAdmin(aPlayer.isAdmin());
		manager.persist(b);
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
		manager.joinTransaction();
		try {
		Player playerInDB = manager.find(Player.class, email);
		System.out.println(player);
		Player updPlayer = util.getObjectForJSON(player, Player.class);
		
		playerInDB.setEmail(updPlayer.getEmail());
		playerInDB.setName(updPlayer.getName());
		playerInDB.setPassword(updPlayer.getPassword());
		playerInDB.setTitle(updPlayer.getTitle());
		playerInDB.setWinCount(updPlayer.getWinCount());
		playerInDB.setLoseCount(updPlayer.getLoseCount());
		playerInDB.setCount7Ball(updPlayer.getCount7Ball());
		playerInDB.setRivalID(updPlayer.getRivalID());
		playerInDB.setAdmin(updPlayer.isAdmin());
		
		}catch(NullPointerException e) {
			return"{\"message\": \"Account not found\"}";
		}
		manager.flush();
		return "{\"message\": \"player sucessfully Updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deletePlayer(String email) {
		System.out.println("finding " + email);
		
		if(manager.contains(manager.find(Player.class, email))){
			manager.remove(manager.find(Player.class, email));
			return "{\"message\": \"player sucessfully deleted\"}";
		}
		return "{\"message\": \"player not found\"}";
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
		
		try {
			Player user = manager.find(Player.class, email);
			if (user.getEmail().equals(email)) {
				if (user.getPassword().equals(password)) {
					System.out.println("{\"message\": \"Login Successful\"}");
					return "{\"message\": \"Login Successful\",\"admin\":"+user.isAdmin()+"}";
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
