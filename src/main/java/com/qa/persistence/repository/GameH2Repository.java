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
		deleteGame(refNum);
		createGame(gameP1, gameP2);
		return "{\"message\": \"player sucessfully Updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteGame(Long refNum) {
		Query query = manager.createQuery("SELECT a From Game a WHERE referenceNumber = " + refNum);
		Collection<Game> games = (Collection<Game>) query.getResultList();
		Game gameInDB = util.getObjectForJSON(getAGame(refNum), Game.class);
		return "{\"message\": \"Game sucessfully deleted\"}";
	}
}
