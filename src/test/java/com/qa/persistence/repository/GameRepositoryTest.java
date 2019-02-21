package com.qa.persistence.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
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

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"referenceNumber\":1,\"resultStatus\":\"N/A\",\"refCount\":0}]";
	private static final String MOCK_OBJECT1 = "{\"gameID\":1,\"playerID\":\"1\",\"referenceNumber\":\"1\",\"resultStatus\":\"N/A\"}";
	private static final String MOCK_OBJECT2 = "{\"gameID\":1,\"playerID\":\"2\",\"referenceNumber\":\"1\",\"resultStatus\":\"N/A\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void createTest() {
		assertEquals("{\"message\": \"Game added\"}", repo.createGame(MOCK_OBJECT1, MOCK_OBJECT2));
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

	@Test
	public void updateTest() {
		fail("TODO");
		assertEquals("{\"message\": \"Game sucessfully Updated\"}", repo.updateGame(MOCK_OBJECT1, MOCK_OBJECT2,1L));
	}

	@Test
	public void deleteTest() {
		fail("TODO");
		String reply = repo.deleteGame(1L);
		assertEquals(reply, "{\"message\": \"Game sucessfully deleted\"}");
	}}
