package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Game;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class GameH2Repository implements GameRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createGame(String gameP1, String gameP2) {
		Game aGame = util.getObjectForJSON(gameP1, Game.class);
		Game bGame = util.getObjectForJSON(gameP2, Game.class);
		manager.persist(aGame);
		manager.persist(bGame);
		return "{\"message\": \"Game added\"}";
	}

	@Override
	public String getAGame(Long refNum) {
		Query query = manager.createQuery("SELECT a From Game a WHERE referenceNumber = " + refNum);
		Collection<Game> games = (Collection<Game>) query.getResultList();
		return util.getJSONForObject(games);
	}

	@Override
	public String getAllGames() {
		Query query = manager.createQuery("SELECT a FROM Game a");
		Collection<Game> games = (Collection<Game>) query.getResultList();
		return util.getJSONForObject(games);
	}

	@Override
	@Transactional(REQUIRED)
	public String updateGame(String gameP1, String gameP2, Long refNum) {
		Query query = manager.createQuery("SELECT a FROM Game a WHERE referenceNumber = " +refNum);
		List<Game> games = (List<Game>) query.getResultList();
		manager.remove(games.get(0));
		manager.remove(games.get(1));
		
		Game aGame = util.getObjectForJSON(gameP1, Game.class);
		Game bGame = util.getObjectForJSON(gameP2, Game.class);
		
		aGame.setReferenceNumber(refNum);
		bGame.setReferenceNumber(refNum);
		manager.persist(aGame);
		manager.persist(bGame);
		return "{\"message\": \"Game sucessfully Updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteGame(Long refNum) {
		Query query = manager.createQuery("SELECT a FROM Game a WHERE referenceNumber = " +refNum);
		List<Game> games = (List<Game>) query.getResultList();
		manager.remove(games.get(0));
		manager.remove(games.get(1));
		return "{\"message\": \"Game sucessfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
