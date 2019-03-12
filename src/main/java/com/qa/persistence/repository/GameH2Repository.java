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
import com.qa.persistence.domain.Player;
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
	public String createGame(String player1, String player2) {
		
		Player p1 = manager.find(Player.class, player1);
		Player p2 = manager.find(Player.class, player2);
		Game aGame = new Game();
		Game bGame = new Game();
		
		aGame.setPlayerId(p1);
		bGame.setPlayerId(p2);
		manager.persist(aGame);
		manager.persist(bGame);
		addReference();
		return "{\"message\": \"Game added\"}";
	}
	@Transactional(REQUIRED)
	public void addReference() {
		manager.joinTransaction();
		Query query = manager.createQuery("SELECT a FROM Game a WHERE reference = null");
		List<Game> games = query.getResultList();
		Long ref = games.get(0).getGameId();
		System.out.println(ref);
		
		games.get(0).setReferenceNumber(ref);
		games.get(1).setReferenceNumber(ref);
		System.out.println(games.toString());
		manager.flush();
	}

	@Override
	public String getAGame(Long refNum) {
		Query query = manager.createQuery("SELECT a From Game a WHERE reference = " + refNum);
		Collection<Game> games = (Collection<Game>) query.getResultList();
		return util.getJSONForObject(games);
	}

	@Override
	public String getAGameByPlayer(String email) {
		Query query = manager.createQuery("SELECT a From Game a WHERE playerId = " + email);
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
	public String updateGame(String winnerEmail, String loserEmail, Long refNum, boolean count7Ball) {
		System.out.println("finding games");
		manager.joinTransaction();
		Query query = manager.createQuery("SELECT a FROM Game a WHERE reference = " + refNum);
		List<Game> games = (List<Game>) query.getResultList();
		boolean winnerIsA;
		if (games.get(0).getPlayerId().getEmail().equals(winnerEmail)) {
			games.get(0).setResultStatus("Win");
			games.get(1).setResultStatus("Loss");
			winnerIsA = true;

		} else {
			games.get(1).setResultStatus("Win");
			games.get(0).setResultStatus("Loss");
			winnerIsA = false;
		}

		System.out.println("before commiting game changes");
		Player a = games.get(0).getPlayerId();
		Player b = games.get(1).getPlayerId();
		manager.flush();

		System.out.println("getting players to update");
		manager.joinTransaction();
		Player winner;
		Player loser;
		if (winnerIsA) {
			winner = manager.find(Player.class, a.getEmail());
			loser = manager.find(Player.class, b.getEmail());
			winner.setWinCount(winner.getWinCount() + 1);
			loser.setLoseCount(loser.getLoseCount() + 1);
		} else {
			winner = manager.find(Player.class, b.getEmail());
			loser = manager.find(Player.class, b.getEmail());
			winner.setWinCount(winner.getWinCount() + 1);
			loser.setLoseCount(loser.getLoseCount() + 1);
		}
		
		if(!loser.getTitle().equals("")) {
			winner.setTitle(loser.getTitle());
			loser.setTitle("");
		}
		
		if(count7Ball) {
			System.out.println(loser.getCount7Ball());
			loser.setCount7Ball((loser.getCount7Ball()+1));
		}
		System.out.println("Commiting Changes to players");
		manager.flush();
		return "{\"message\": \"Game sucessfully Updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteGame(Long id) {
		manager.remove(manager.find(Game.class, id));
		return "{\"message\": \"Game sucessfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
