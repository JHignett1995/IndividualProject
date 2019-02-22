package com.qa.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.qa.persistence.repository.GameRepository;
import com.qa.persistence.repository.PlayerRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {
	@InjectMocks
	private GameServiceImpl service;
	
	@Mock
	private GameRepository repo;
	
	private static final String MOCK_OBJECT1 = "{\"gameID\":1,\"playerID\":\"1\",\"referenceNumber\":\"1\",\"resultStatus\":\"N/A\"}";
	private static final String MOCK_OBJECT2 = "{\"gameID\":1,\"playerID\":\"2\",\"referenceNumber\":\"1\",\"resultStatus\":\"N/A\"}";

	@Before
	public void setup() {
		service.setRepo(repo);
	}
	
	@Test
	public void createTest() {
		Mockito.when(repo.createGame(MOCK_OBJECT1, MOCK_OBJECT2)).thenReturn("Game created");
		assertEquals("Game created", service.addGame(MOCK_OBJECT1, MOCK_OBJECT2));
	}
	
	@Test
	public void getATest() {
		Mockito.when(repo.getAGame(1L)).thenReturn("Game fetched");
		assertEquals("Game fetched", service.getAGame(1L));
	}
	
	@Test
	public void getAllTest() {
		Mockito.when(repo.getAllGames()).thenReturn("Games fetched");
		assertEquals("Games fetched", service.getAllGames());
	}
	
	@Test
	public void updateTest() {
		Mockito.when(repo.updateGame(MOCK_OBJECT1, MOCK_OBJECT2,1L)).thenReturn("Game updated");
		assertEquals("Game updated", service.updateGame(MOCK_OBJECT1,MOCK_OBJECT2,1L));
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(repo.deleteGame(1L)).thenReturn("Game deleted");
		assertEquals("Game deleted", service.deleteGame(1L));
	}
}
