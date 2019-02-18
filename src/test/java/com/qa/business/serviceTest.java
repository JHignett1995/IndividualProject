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
import com.qa.persistence.domain.Player;
import com.qa.persistence.repository.PlayerRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class serviceTest {
	@InjectMocks
	private PlayerServiceImpl service;
	
	@Mock
	private PlayerRepository repo;
	
	@Mock
	private JSONUtil util;
	
	private static final String goodPlayer = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badName1 = "{\"email\": \"1@gmail.com\",\"name\":\"J1rdan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badName2 = "{\"email\": \"1@gmail.com\",\"name\":\"Jshitordan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badPass1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"pswod\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badPass2 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"password\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";
	private static final String badPass3 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@qa.com\",\"isAdmin\":\"true\"}";

	@Before
	public void setupRepos(){
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}
	@Test
	public void addPlayerTestTotal() {
		Mockito.when(repo.createPlayer(goodPlayer)).thenReturn("{\"message\": \"Player has been added\"}");
		assertEquals("{\"message\": \"Player has been added\"}",service.addPlayer(goodPlayer));
	}
	
	@Test
	public void addPlayerTestNameContainsNonWordChar() {	
			String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"32515\",\"password\":\"password\"}";
			assertEquals("{\"message\": \"You have entered an invalid character\"}",service.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestNameContainsProfanity() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordanpussyfuck\",\"password\":\"password\"}";
		assertEquals("{\"message\": \"You have entered an name containing profanity\"}",service.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestPasswordLength() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"psord\"}";
		assertEquals("{\"message\": \"You have entered an incorrect password, password must be 6 chars minimal\"}",service.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestPasswordContainsANumber() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"password\"}";
		assertEquals("{\"message\": \"You have entered an incorrect password, password must contain a number\"}",service.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestPasswordContainsACap() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\": \"pa5sword \"}";
		assertEquals("{\"message\": \"You have entered an incorrect password, password must contain a capitial\"}",service.addPlayer(play1));
	}
	
	@Test
	public void getAllPlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void getAPlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void removePlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void remove2PlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void updatePlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void update2PlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void addGameTest() {	
		fail("TODO");
	}
	
	@Test
	public void add2GameTest() {
		fail("TODO");
	}
	@Test
	public void getAllGamesTest() {
		fail("TODO");
	}
	
	@Test
	public void getAGameTest() {
		fail("TODO");
	}
	
	@Test
	public void removeGameTest() {
		fail("TODO");
	}
	
	@Test
	public void remove2GameTest() {
		fail("TODO");
	}
	
	@Test
	public void updateGameTest() {
		fail("TODO");
	}
	
	@Test
	public void update2GameTest() {
		fail("TODO");
	}
	
	
}
