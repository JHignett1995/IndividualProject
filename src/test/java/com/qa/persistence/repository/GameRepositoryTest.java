package com.qa.persistence.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class GameRepositoryTest {
	@InjectMocks
	private GameH2Repository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	@Mock
	private JSONUtil util;

	@Mock
	PlayerH2Repository pRepo;

	private static final String MOCK_DATA_ARRAY = "[{\"resultStatus\":\"N/A\",\"gameCount\":0}]";
	private static final String MOCK_OBJECT1 = "{\"gameID\":1,\"playerID\":\"1\",\"referenceNumber\":\"1\",\"resultStatus\":\"N/A\"}";
	private static final String MOCK_OBJECT2 = "{\"gameID\":1,\"playerID\":\"2\",\"referenceNumber\":\"1\",\"resultStatus\":\"N/A\"}";
	private static final Player MockPlay1 = new Player();
	private static final Player MockPlay2= new Player();
	private static final String MOCK_player_ARRAY = "[{\"email\":\"1@gmail.com\",\"games\":[],\"name\":\"Jordan\",\"title\":\"\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"\",\"isAdmin\":false}]";
	

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		pRepo = new PlayerH2Repository();
	}

	@Ignore
	public void createTest() {
		Mockito.when(manager.createQuery("SELECT a FROM Player a WHERE email='1@gmail.com'")).thenReturn(query);
		Mockito.when(manager.createQuery("SELECT a FROM Player a WHERE email='2@gmail.com'")).thenReturn(query);
		Mockito.when(pRepo.getAPlayerEmail("1@gmail.com")).thenReturn(util.getJSONForObject(MockPlay1));
		Mockito.when(pRepo.getAPlayerEmail("2@gmail.com")).thenReturn(util.getJSONForObject(MockPlay2));
		assertEquals("{\"message\": \"Game added\"}", repo.createGame("1@gmail.com", "2@gmail.com"));
	}

	@Test
	public void getAllTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Game> games = new ArrayList<Game>();
		games.add(util.getObjectForJSON(MOCK_OBJECT1, Game.class));
		Mockito.when(query.getResultList()).thenReturn(games);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllGames());
	}

	@Test
	public void getATest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Game> games = new ArrayList<Game>();
		games.add(util.getObjectForJSON(MOCK_OBJECT1, Game.class));
		Mockito.when(query.getResultList()).thenReturn(games);
		assertEquals(MOCK_DATA_ARRAY, repo.getAGame(1L));
	}

	@Ignore
	public void updateTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Game> games = new ArrayList<Game>();
		Mockito.when(query.getResultList()).thenReturn(games);
		Mockito.when(games.get(0).getPlayerId().getEmail().equals("1@gmail.com")).thenReturn(true);
		assertEquals("{\"message\": \"Game sucessfully Updated\"}", repo.updateGame(MOCK_OBJECT1, MOCK_OBJECT2, 1L,false));
	}

	@Test
	public void deleteTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Game> games = new ArrayList<Game>();
		games.add(util.getObjectForJSON(MOCK_OBJECT1, Game.class));
		games.add(util.getObjectForJSON(MOCK_OBJECT2, Game.class));
		Mockito.when(query.getResultList()).thenReturn(games);
		assertEquals("{\"message\": \"Game sucessfully deleted\"}", repo.deleteGame(1L));
	}
}
