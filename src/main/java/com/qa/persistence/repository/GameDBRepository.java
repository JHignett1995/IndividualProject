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
public class GameDBRepository implements GameRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	
	@Override
	@Transactional(REQUIRED)
	public String createGame(String game) {
		Game aGame = util.getObjectForJSON(game, Game.class);
		manager.persist(aGame);
		return "{\"message\": \"Game added\"}";
	}

	@Override
	public String getAGame(Long id) {
		return util.getJSONForObject(manager.find(Game.class, id));
	}

	@Override
	public String getAllGames() {
		Query query = manager.createQuery("SELECT a FROM Game a");
		Collection<Game> games = (Collection<Game>) query.getResultList();
		return util.getJSONForObject(games);
	}

	@Override
	@Transactional(REQUIRED)
	public String updateGame(String game, Long id) {
		deleteGame(id);
		createGame(game);
		return "{\"message\": \"player sucessfully Updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteGame(Long id) {
		Game gameInDB = util.getObjectForJSON(getAGame(id), Game.class);

		if (manager.contains(manager.find(Game.class, id))) {

			manager.remove(manager.find(Game.class, id));
		}
		return "{\"message\": \"Game sucessfully deleted\"}";
	}
}
