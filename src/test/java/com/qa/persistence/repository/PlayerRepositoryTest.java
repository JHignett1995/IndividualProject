package com.qa.persistence.repository;

import static org.junit.Assert.assertEquals;

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

import com.qa.persistence.domain.Player;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class PlayerRepositoryTest {
	@InjectMocks
	private PlayerH2Repository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"email\":\"1@gmail.com\",\"name\":\"Jordan\",\"title\":\"\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"\",\"isAdmin\":false}]";
	private static final Player MOCKPlayer = new Player("1@gmail.com","Jordan", "Password1");
	private static final String MOCK_OBJECT1 = "{\"email\":\"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"isAdmin\":false}";
	private static final String MOCK_OBJECT2 = "{\"firstName\":\"jordan\",\"lastName\":\"hignett\",\"PlayerNumber\":123}";
	private final List<Player> MockArray =  new ArrayList();

	@Before
	public void setup() {
		MockArray.add(MOCKPlayer);
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void createTest() {
		String reply = repo.createPlayer(MOCK_OBJECT1);
		assertEquals(reply, "{\"message\": \"Player has been added\"}");
	}

	@Test
	public void getAllTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Player> Players = new ArrayList<Player>();
		Players.add(new Player("1@gmail.com", "Jordan", "Password1"));
		Mockito.when(query.getResultList()).thenReturn(Players);
		System.out.println(repo.getAllPlayers());
		assertEquals(MOCK_DATA_ARRAY, repo.getAllPlayers());
	}

	@Test
	public void getATest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Player> Players = new ArrayList<Player>();
		Players.add(new Player("1@gmail.com", "Jordan", "Password1"));
		Mockito.when(query.getResultList()).thenReturn(Players);
		System.out.println(repo.getAPlayerEmail("1@gmail.com"));
		assertEquals(MOCK_DATA_ARRAY, repo.getAllPlayers());
	}

	@Ignore
	public void updateTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(MockArray);
		
		assertEquals("{\"message\": \"player sucessfully Updated\"}",repo.updatePlayer(MOCK_OBJECT1, "1@gmail.com"));
	}

	@Test
	public void deleteTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(MockArray);
		String reply = repo.deletePlayer("1@gmail.com");
		assertEquals("{\"message\": \"player not found\"}", repo.deletePlayer("1@gmail.com"));
	}
}
