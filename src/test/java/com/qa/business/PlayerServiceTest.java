package com.qa.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.business.PlayerServiceImpl;
import com.qa.persistence.repository.PlayerRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {
	@InjectMocks
	private PlayerServiceImpl service;

	@Mock
	private PlayerRepository repo;

	@Mock
	private JSONUtil util;

	private static final String goodPlayer = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String noName = "{\"email\": \"1@gmail.com\",\"name\":\"\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badName1 = "{\"email\": \"1@gmail.com\",\"name\":\"J1rdan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badName2 = "{\"email\": \"1@gmail.com\",\"name\":\"Jshitordan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badName3 = "{\"email\": \"1@gmail.com\",\"name\":\"J!rdan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badPass1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"pswod\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badPass2 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"password\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badPass3 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";

	@Before
	public void setupRepos() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}

	@Test
	public void addPlayerTestTotal() {
		Mockito.when(repo.createPlayer(goodPlayer)).thenReturn("{\"message\": \"Player has been added\"}");
		assertEquals("{\"message\": \"Player has been added\"}", service.addPlayer(goodPlayer));
	}

	@Test
	public void testNameIsBlank() {
		assertEquals("{\"message\": \"You have'nt entered a Name\"}", service.addPlayer(noName));
	}
	
	@Test
	public void addPlayerTestNameContainsNonWordChar() {
		Mockito.when(repo.createPlayer(badName1)).thenReturn("{\"message\": \"Player has been added\"}");
		assertEquals("{\"message\": \"You have entered an invalid character\"}", service.addPlayer(badName1));
	}
	
	@Test
	public void addPlayerTestNameContainsNonWordChar2() {
		Mockito.when(repo.createPlayer(badName1)).thenReturn("{\"message\": \"Player has been added\"}");
		assertEquals("{\"message\": \"You have entered an invalid character\"}", service.addPlayer(badName3));
	}

	@Test
	public void addPlayerTestNameContainsProfanity() {
		assertEquals("{\"message\": \"You have entered an name containing profanity\"}", service.addPlayer(badName2));
	}

	@Test
	public void addPlayerTestPasswordLength() {
		assertEquals("{\"message\": \"You have entered an incorrect password, password must be 6 chars minimal\"}",
				service.addPlayer(badPass1));
	}

	@Test
	public void addPlayerTestPasswordContainsANumber() {
		assertEquals("{\"message\": \"You have entered an incorrect password, password must contain a number\"}",
				service.addPlayer(badPass2));
	}

	@Test
	public void addPlayerTestPasswordContainsACap() {
		assertEquals("{\"message\": \"You have entered an incorrect password, password must contain a capitial\"}",
				service.addPlayer(badPass3));
	}

	@Test
	public void getAllPlayerTest() {
		Mockito.when(repo.getAllPlayers()).thenReturn("Got all the players");
		assertEquals("Got all the players", service.getAllPlayers());
	}

	@Test
	public void getAPlayerTest() {
		Mockito.when(repo.getAPlayerEmail("1@gmail.com")).thenReturn(goodPlayer);
		assertEquals(goodPlayer, service.getAPlayerEmail("1@gmail.com"));
	}

	@Test
	public void removePlayerTest() {
		Mockito.when(repo.deletePlayer("1@gmail.com")).thenReturn("Player Deleted");
		assertEquals("Player Deleted", service.deletePlayer("1@gmail.com"));
	}

	@Test
	public void updatePlayerTest() {
		Mockito.when(repo.updatePlayer(goodPlayer, "1@gmail.com")).thenReturn("Player Updated");
		assertEquals("Player Updated", service.updatePlayer(goodPlayer, "1@gmail.com"));
	}
}
